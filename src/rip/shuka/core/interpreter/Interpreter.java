package rip.shuka.core.interpreter;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.functions.RuntimeFunction;
import rip.shuka.core.logic.functions.RuntimeFunctionStore;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.utils.ErrorUtil;
import rip.shuka.core.logic.*;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.functions.FunctionHolder;

import java.util.Objects;

import static rip.shuka.core.interpreter.InterpreterForParameter.interpretParameter;

public class Interpreter {
    public static DatatypeObject[] interpretLine(String line, int lineNumber) {
        String[] lineParts = line.split(" ");
        DatatypeObject[] results = new DatatypeObject[lineParts.length];

        for (int i = 0; i < lineParts.length; i++) {
            String argument = lineParts[i];
            boolean argumentFound = false;

            // skip empty arguments
            if (Objects.equals(argument, "")) {
                continue;
            }

            // Build Loop Content
            if (InterpreterStateStore.loop_information.size() != 0) {
                LoopInformation loopInformation = InterpreterStateStore.loop_information.get(InterpreterStateStore.loop_information.size() - 1);

                if (!loopInformation.isLooping) {
                    if (argument.startsWith(LogicRegister.loopFH.getName() + ".end()")) {
                        loopInformation.isLooping = true;

                        for (int j = 0; j < loopInformation.times; j++) {
                            for (int k = 0; k < loopInformation.getLines().length && !InterpreterStateStore.loopBreaked; k++) {
                                if (InterpreterStateStore.loopBreaked) {
                                    InterpreterStateStore.loopBreaked = false;
                                    break;
                                } else {
                                    interpretLine(loopInformation.getLines()[k], lineNumber);
                                }
                            }
                        }

                        continue;
                    }

                    String[] lines = loopInformation.getLines();
                    String[] newLines = new String[lines.length + 1];
                    System.arraycopy(lines, 0, newLines, 0, lines.length);
                    newLines[newLines.length - 1] = line;
                    loopInformation.setLines(newLines);

                    continue;
                }
            }

            // Check for Break
            if (argument.startsWith(LogicRegister.loopFH.getName() + ".break()") && InterpreterStateStore.if_result) {
                InterpreterStateStore.loop_information.remove(InterpreterStateStore.loop_information.size() - 1);
                InterpreterStateStore.loopBreaked = true;
                break;
            }

            // Check for interpreter changeable functions
            if (argument.startsWith(LogicRegister.funcFH.getName() + ".end()")) {
                InterpreterStateStore.function_flag = false;
                continue;
            }

            // Check for function content
            if (InterpreterStateStore.function_flag) {
                RuntimeFunctionStore.getFunctions()[RuntimeFunctionStore.getFunctions().length - 1].addLine(line);
                break;
            }

            // If Ends Check
            if (argument.startsWith(LogicRegister.csFH.getName() + ".if_ends()")) {
                InterpreterStateStore.if_result = true;
                continue;
            }

            // Else Check
            if (argument.startsWith(LogicRegister.csFH.getName() + ".else()")) {
                InterpreterStateStore.else_flag = true;
                continue;
            }

            // When if is false or argument is empty
            if ((InterpreterStateStore.if_result == InterpreterStateStore.else_flag)) {
                continue;
            }

            // Space Wildcard for Parameters
            if (argument.endsWith(",")) {
                lineParts[i + 1] = argument + lineParts[i + 1];
                continue;
            }

            // Comment Check
            DatatypeObject[] res = checkForComments(argument);
            if (res != null) {
                return res;
            }

            // Check for interpreter changeable functions
            if (argument.startsWith(LogicRegister.csFH.getName() + ".")) {
                String func = argument.replace(LogicRegister.csFH.getName() + ".", "");

                // IF FUNCTION
                if (func.startsWith("if" + "(") && argument.endsWith(")")) {
                    Function logicElement = LogicRegister.csFH.getFunction("if");
                    String parameter = argument.substring(logicElement.getName().length() + LogicRegister.csFH.getName().length() + 2, argument.length() - 1);
                    DatatypeObject[] interpreted_parameters = interpretParameter(parameter, logicElement.getParameters(), lineNumber, i + 1, func);
                    InterpreterStateStore.if_result = Boolean.parseBoolean(interpreted_parameters[0].value());
                    continue;
                }
            }

            // Check for loop function
            if (argument.startsWith(LogicRegister.loopFH.getName() + ".")) {
                String func = argument.replace(LogicRegister.loopFH.getName() + ".", "");

                // REPEAT FUNCTION
                if (func.startsWith("repeat" + "(") && argument.endsWith(")")) {
                    Function logicElement = LogicRegister.loopFH.getFunction("repeat");
                    String parameter = argument.substring(logicElement.getName().length() + LogicRegister.loopFH.getName().length() + 2, argument.length() - 1);
                    DatatypeObject[] interpreted_parameters = interpretParameter(parameter, logicElement.getParameters(), lineNumber, i + 1, func);
                    InterpreterStateStore.loop_information.add(new LoopInformation(Integer.parseInt(interpreted_parameters[0].value()), new String[]{}));
                    continue;
                }
            }

            // Check for new runtime function
            if (argument.startsWith(LogicRegister.funcFH.getName() + ".")) {
                String func = argument.replace(LogicRegister.funcFH.getName() + ".", "");
                String funcName = func.split("\\(")[0];
                Function logicElement = LogicRegister.funcFH.getFunction(funcName);

                if (func.startsWith("new" + "(") && argument.endsWith(")")) {
                    String parameter = argument.substring(logicElement.getName().length() + LogicRegister.funcFH.getName().length() + 2, argument.length() - 1);
                    DatatypeObject[] interpreted_parameters = interpretParameter(parameter, logicElement.getParameters(), lineNumber, i + 1, func);

                    Parameter[] parameters = new Parameter[interpreted_parameters.length - 1];
                    for (int j = 0; j < interpreted_parameters.length; j++) {
                        if (j == 0) {
                            continue;
                        }

                        DatatypeObject parameterObject = interpreted_parameters[j];
                        parameters[j - 1] = new Parameter(parameterObject, new Datatype[]{ parameterObject.datatype() }, "parameter" + j);
                    }

                    RuntimeFunction runtimeFunction = new RuntimeFunction(interpreted_parameters[0].value(), parameters);
                    RuntimeFunctionStore.addFunction(runtimeFunction);
                    InterpreterStateStore.function_flag = true;
                    continue;
                }
            }

            // Check for runtime functions
            if (argument.startsWith(LogicRegister.funcFH.getName() + ".")) {
                String func = argument.replace(LogicRegister.funcFH.getName() + ".", "");
                String funcName = func.split("\\(")[0];

                RuntimeFunction runtimeFunction = RuntimeFunctionStore.getFunction(funcName);

                if (runtimeFunction == null) {
                    runtimeFunction = RuntimeFunctionStore.getFunction(InterpreterStateStore.latest_runtime_function_name);
                } else {
                    InterpreterStateStore.latest_runtime_function_name = funcName;
                }

                // Parameter checks
                String parameter = argument.substring(funcName.length() + LogicRegister.funcFH.getName().length() + 2, argument.length() - 1);
                assert runtimeFunction != null;
                DatatypeObject[] interpreted_parameters = interpretParameter(parameter, runtimeFunction.getParameters(), lineNumber, i + 1, func);

                // Replace Parameter keywords in lines with values
                for (int j = 0; j < runtimeFunction.getLines().length; j++) {
                    String line1 = runtimeFunction.getLines()[j];

                    for (int k = 0; k < interpreted_parameters.length; k++) {
                        String searchFor = LogicRegister.funcFH.getName() + ".param(int<" + (k + 1) + ">)";

                        String replaceWith = interpreted_parameters[k].value();
                        switch (interpreted_parameters[k].datatype().getName()) {
                            case "str":
                                replaceWith = "str<" + replaceWith + ">";
                                break;
                            case "int":
                                replaceWith = "int<" + replaceWith + ">";
                                break;
                            case "bool":
                                replaceWith = "bool<" + replaceWith + ">";
                                break;
                            case "float":
                                replaceWith = "float<" + replaceWith + ">";
                                break;
                            case "any":
                                replaceWith = "any<" + replaceWith + ">";
                                break;
                            case "null":
                                replaceWith = "null<" + replaceWith + ">";
                        }

                        line1 = line1.replace(searchFor, replaceWith);

                        String[] newLines = runtimeFunction.getLines();
                        newLines[j] = line1;
                        runtimeFunction.setLines(newLines);
                    }

                    // check if there is any called parameter left
                    if (line1.contains(LogicRegister.funcFH.getName() + ".param")) {
                        ErrorUtil.callError("Parameter not found at line " + lineNumber);
                    }
                }

                if (runtimeFunction != null) {
                    for (String eachLine : runtimeFunction.getLines()) {
                        interpretLine(eachLine, lineNumber);
                    }

                    continue;
                } else {
                    ErrorUtil.callError("Runtime function " + funcName + " not found at line " + lineNumber);
                }
            }

            // Check each functionHolder
            for (FunctionHolder functionHolder : LogicRegister.functionHolder) {
                // Function [fh.func()] matching only the beginning of the string
                if (argument.startsWith(functionHolder.getName() + ".")) {
                    String func = argument.replace(functionHolder.getName() + ".", "");
                    String funcName = func.split("\\(")[0];
                    Function logicElement = functionHolder.getFunction(funcName);

                    if (logicElement == null) {
                        ErrorUtil.callError("Function " + funcName + " not found at line " + lineNumber);
                    }

                    assert logicElement != null;
                    if (func.startsWith(logicElement.getName() + "(") && argument.endsWith(")")) {
                        String parameter = argument.substring(logicElement.getName().length() + functionHolder.getName().length() + 2, argument.length() - 1);
                        DatatypeObject[] interpreted_parameters = interpretParameter(parameter, logicElement.getParameters(), lineNumber, i + 1, func);
                        results[i] = logicElement.execute(interpreted_parameters);
                        argumentFound = true;
                        break;
                    }
                }
            }

            if (!argumentFound) {
                // If the argument is not a function or baseElement
                ErrorUtil.callError("Argument <" + argument + "> at line " + lineNumber + " and position " + (i + 1) + " does NOT make sense :(");
            }
        }

        return results;
    }

    private static DatatypeObject[] checkForComments(String argument) {
        if (argument.startsWith(LogicRegister.comments.getIdentifier())) {
            return new DatatypeObject[0];
        }

        return null;
    }
}
