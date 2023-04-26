package rip.shuka.core.interpreter;

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

            if (Objects.equals(argument, "")) {
                break;
            }

            // Space Wildcard for Parameters
            if (argument.endsWith(",")) {
                lineParts[i+1] = argument + lineParts[i+1];
                continue;
            }

            for (LogicElement logicElement : LogicCollection.langBasics) {
                // Comment matching only the beginning of the string
                if (argument.startsWith(logicElement.getName())) {
                    results[i] = logicElement.execute(new DatatypeObject[0]);
                    // Return so line is not interpreted anymore because it's a comment
                    return results;
                }
            }

            // Check each functionHolder
            for (FunctionHolder functionHolder : LogicCollection.functionHolder) {
                // Function [fh.func()] matching only the beginning of the string
                if (argument.startsWith(functionHolder.getName() + ".")) {
                    for (LogicElement logicElement : functionHolder.getFunctions()) {
                        if (argument.replace(functionHolder.getName() + ".", "").startsWith(logicElement.getName() + "(") && argument.endsWith(")")) {
                            String parameter = argument.substring(logicElement.getName().length() + functionHolder.getName().length() + 2, argument.length() - 1);
                            DatatypeObject[] interpreted_parameters = interpretParameter(parameter, logicElement.getParameters(), lineNumber, i+1, argument.replace(functionHolder.getName() + ".", ""));
                            results[i] = logicElement.execute(interpreted_parameters);
                            argumentFound = true;
                            break;
                        }
                    }

                    if (!argumentFound) {
                        ErrorUtil.callError("Unknown function <" + argument.replace(functionHolder.getName() + ".", "") + "> for FunctionHolder <" + functionHolder.getName() +  "> on line " + lineNumber);
                    }
                }
            }

            if (!argumentFound) {
                // If the argument is not a syntaxElement
                ErrorUtil.callError("Argument <" + argument + "> at line " + lineNumber + " and position " + (i+1) + " does NOT make sense :(");
            }
        }

        return results;
    }
}
