package rip.shuka.core.interpreter;

import rip.shuka.core.error.CallError;
import rip.shuka.core.syntax.*;
import rip.shuka.core.syntax.datatypes.DatatypeObject.DatatypeObject;

import java.util.Objects;

public class Interpreter {
    public DatatypeObject[] interpretLine(String line, int lineNumber) {
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

            // Check each syntaxElement
            for (SyntaxElement syntaxElement : SyntaxVars.syntaxElements) {
                // Function [name()] matching only the beginning of the string
                if (syntaxElement.getType() == SyntaxTypes.FUNCTION && argument.startsWith(syntaxElement.getName())) {
                    if (argument.startsWith(syntaxElement.getName() + "(") && argument.endsWith(")")) {
                        String parameter = argument.substring(syntaxElement.getName().length() + 1, argument.length() - 1);
                        DatatypeObject[] interpreted_parameters = interpretParameter(parameter, syntaxElement.getParameters(), lineNumber, i+1);
                        results[i] = syntaxElement.execute(interpreted_parameters);
                        argumentFound = true;
                        break;
                    } else {
                        CallError.callError("Unclosed function at line " + lineNumber + " and position " + (i+1) + " | Maybe try: " + argument + "()");
                    }
                }

                // Comment matching only the beginning of the string
                if (syntaxElement.getType() == SyntaxTypes.COMMENT && argument.startsWith(syntaxElement.getName())) {
                    results[i] = syntaxElement.execute(new DatatypeObject[0]);
                    // Return so line is not interpreted anymore because it's a comment
                    return results;
                }
            }

            if (!argumentFound) {
                // If the argument is not a syntaxElement
                CallError.callError("Argument <" + argument + "> at line " + lineNumber + " and position " + (i+1) + " does NOT make sense :(");
            }
        }

        return results;
    }

    public DatatypeObject[] interpretParameter(String given_parameter, Parameter[] parameters, int lineNumber, int position) {
        String[] given_parameters = given_parameter.split(",");
        int required_parameter = 0;

        for (Parameter parameter : parameters) {
            if (parameter.isRequired()) {
                required_parameter++;
            }
        }

        for (String parameter : given_parameters) {
            if (Objects.equals(parameter, "")) {
                if (required_parameter == 0) {
                    return new DatatypeObject[0];
                } else {
                    CallError.callError(
                            "The function on line " + lineNumber + " and position " + position + " has " +
                            parameters.length + " parameters but " + (given_parameters.length - 1) + " were given."
                    );
                }
            }
        }

        if (given_parameters.length != parameters.length) {
            CallError.callError("The function has " + parameters.length + " parameters but " + given_parameters.length + " were given.");
        }

        DatatypeObject[] interpretedParameters = new DatatypeObject[given_parameters.length];

        for (int i = 0; i < given_parameters.length; i++) {
            DatatypeObject interpretedParameter = InterpreterForDatatype.interpretDatatype(given_parameters[i], lineNumber);

            if (interpretedParameter == null) {
                interpretedParameter = interpretLine(given_parameters[i], lineNumber)[0];
            }

            if (!interpretedParameter.isValidDatatype(parameters[i].getTypes())) {
                StringBuilder allowedDatatypes = new StringBuilder();

                for (Datatype datatype : parameters[i].getTypes()) {
                    allowedDatatypes.append(datatype.getName()).append(", ");
                }

                allowedDatatypes = new StringBuilder(allowedDatatypes.substring(0, allowedDatatypes.length() - 2));

                CallError.callError(
                        "The parameter <" + given_parameters[i] + "> at line " + lineNumber + " and position " + position + " is not a valid datatype. " +
                        "Valid datatypes are: '" + allowedDatatypes + "' but you tried to use " + interpretedParameter.datatype().getName() + ".");
            }

            interpretedParameters[i] = interpretedParameter;
        }

        return interpretedParameters;
    }
}
