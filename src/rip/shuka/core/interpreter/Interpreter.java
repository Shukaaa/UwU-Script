package rip.shuka.core.interpreter;

import rip.shuka.core.error.CallError;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;
import rip.shuka.core.syntax.SyntaxVars;

import java.util.Objects;

public class Interpreter {
    public void interpretLine(String line, int lineNumber) {
        String[] lineParts = line.split(" ");

        for (int i = 0; i < lineParts.length; i++) {
            String argument = lineParts[i];
            boolean argumentFound = false;

            // Check each syntaxElement
            for (SyntaxElement syntaxElement : SyntaxVars.syntaxElements) {
                // Function [name()] matching only the beginning of the string
                if (syntaxElement.getType() == SyntaxTypes.FUNCTION && argument.startsWith(syntaxElement.getName())) {
                    if (argument.startsWith(syntaxElement.getName() + "(") && argument.endsWith(")")) {
                        String parameter = argument.substring(syntaxElement.getName().length() + 1, argument.length() - 1);
                        String[] interpreted_parameters = interpretParameter(parameter, syntaxElement.getParameters().length, lineNumber);
                        syntaxElement.execute(interpreted_parameters);
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
    }

    public String[] interpretParameter(String parameter, int numberOfParameters, int lineNumber) {
        String[] parameters = parameter.split(",");

        if (parameters.length != numberOfParameters) {
            CallError.callError("The function has " + numberOfParameters + " parameters but " + parameters.length + " were given.");
        }

        String[] interpretedParameters = new String[parameters.length];

        for (int i = 0; i < parameters.length; i++) {
            interpretedParameters[i] = InterpreterForDatatype.interpretDatatype(parameters[i], lineNumber);
        }

        return interpretedParameters;
    }
}
