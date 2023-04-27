package rip.shuka.core.interpreter;

import rip.shuka.core.logic.functions.Function;
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
                lineParts[i + 1] = argument + lineParts[i + 1];
                continue;
            }

            // Comment Check
            DatatypeObject[] res = checkForComments(argument);

            if (res != null) {
                return res;
            }

            // Check each functionHolder
            for (FunctionHolder functionHolder : LogicCollection.functionHolder) {
                // Function [fh.func()] matching only the beginning of the string
                if (argument.startsWith(functionHolder.getName() + ".")) {
                    for (Function logicElement : functionHolder.getFunctions()) {
                        if (argument.replace(functionHolder.getName() + ".", "").startsWith(logicElement.getName() + "(") && argument.endsWith(")")) {
                            String parameter = argument.substring(logicElement.getName().length() + functionHolder.getName().length() + 2, argument.length() - 1);
                            DatatypeObject[] interpreted_parameters = interpretParameter(parameter, logicElement.getParameters(), lineNumber, i + 1, argument.replace(functionHolder.getName() + ".", ""));
                            results[i] = logicElement.execute(interpreted_parameters);
                            argumentFound = true;
                            break;
                        }
                    }

                    if (!argumentFound) {
                        ErrorUtil.callError("Unknown function <" + argument.replace(functionHolder.getName() + ".", "") + "> for FunctionHolder <" + functionHolder.getName() + "> on line " + lineNumber);
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
        if (argument.startsWith(LogicCollection.comments.getIdentifier())) {
            return new DatatypeObject[0];
        }

        return null;
    }
}
