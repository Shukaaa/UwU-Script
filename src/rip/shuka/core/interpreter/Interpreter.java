package rip.shuka.core.interpreter;

import rip.shuka.core.error.CallError;
import rip.shuka.core.syntax.*;

import java.util.Arrays;
import java.util.Objects;

public class Interpreter {
    public Object[] interpretLine(String line, int lineNumber) {
        String[] lineParts = line.split(" ");
        Object[] results = new Object[lineParts.length];

        for (int i = 0; i < lineParts.length; i++) {
            String argument = lineParts[i];
            boolean argumentFound = false;

            // Check each syntaxElement
            for (SyntaxElement syntaxElement : SyntaxVars.syntaxElements) {
                // Function [name()] matching only the beginning of the string
                if (syntaxElement.getType() == SyntaxTypes.FUNCTION && argument.startsWith(syntaxElement.getName())) {
                    if (argument.startsWith(syntaxElement.getName() + "(") && argument.endsWith(")")) {
                        String parameter = argument.substring(syntaxElement.getName().length() + 1, argument.length() - 1);
                        String[] interpreted_parameters = interpretParameter(parameter, syntaxElement.getParameters(), lineNumber);
                        results[i] = syntaxElement.execute(interpreted_parameters);
                        argumentFound = true;
                        break;
                    } else {
                        CallError.callError("Unclosed function at line " + lineNumber + " and position " + (i+1) + " | Maybe try: " + argument + "()");
                    }
                }

                // Comment matching only the beginning of the string
                if (syntaxElement.getType() == SyntaxTypes.COMMENT && argument.startsWith(syntaxElement.getName())) {
                    argumentFound = true;
                    break;
                }
            }

            if (Objects.equals(argument, "")) {
                break;
            }

            if (!argumentFound) {
                // If the argument is not a syntaxElement
                CallError.callError("Argument <" + argument + "> at line " + lineNumber + " and position " + i + " does NOT make sense :(");
            }
        }

        return results;
    }

    public String[] interpretParameter(String given_parameter, Parameter[] parameters, int lineNumber) {
        String[] given_parameters = given_parameter.split(",");

        if (given_parameters.length != parameters.length) {
            CallError.callError("The function has " + parameters.length + " parameters but " + given_parameters.length + " were given.");
        }

        String[] interpretedParameters = new String[given_parameters.length];

        for (int i = 0; i < given_parameters.length; i++) {
            String interpetedParameter = InterpreterForDatatype.interpretDatatype(given_parameters[i], lineNumber);

            if (interpetedParameter == null) {
                interpretedParameters[i] = (String) interpretLine(given_parameters[i], lineNumber)[0];
                continue;
            }

            interpretedParameters[i] = interpetedParameter;
        }

        for (Object result : interpretedParameters) {
            //System.out.println(result);
        }

        return interpretedParameters;
    }
}
