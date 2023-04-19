package rip.shuka.core.interpreter;

import rip.shuka.core.error.CallError;
import rip.shuka.core.syntax.SyntaxDatatype;
import rip.shuka.core.syntax.SyntaxVars;

public class InterpreterForDatatype {
    public static String interpretDatatype(String argument, int lineNumber) {
        // Check each syntaxDatatype
        for (SyntaxDatatype syntaxDatatype : SyntaxVars.syntaxDatatypes) {
            if (syntaxDatatype.getType() == Integer.class && argument.startsWith(syntaxDatatype.getName())) {
                if (argument.startsWith(syntaxDatatype.getName() + "<") && argument.endsWith(">")) {
                    String data = argument.substring(syntaxDatatype.getName().length() + 1, argument.length() - 1);

                    try {
                        Integer.parseInt(data);
                    } catch (NumberFormatException e) {
                        CallError.callError("Datatype <" + syntaxDatatype.getName() + "> at line " + lineNumber + " is not a valid integer.");
                    }

                    return data;
                }
            }

            if (syntaxDatatype.getType() == String.class && (argument.startsWith(syntaxDatatype.getName()))) {
                if (argument.startsWith(syntaxDatatype.getName() + "<") && argument.endsWith(">")) {
                    return argument.substring(syntaxDatatype.getName().length() + 1, argument.length() - 1);
                }
            }

            if (syntaxDatatype.getType() == Float.class && argument.startsWith(syntaxDatatype.getName())) {
                if (argument.startsWith(syntaxDatatype.getName() + "<") && argument.endsWith(">")) {
                    String data = argument.substring(syntaxDatatype.getName().length() + 1, argument.length() - 1);

                    try {
                        Double.parseDouble(data);
                    } catch (NumberFormatException e) {
                        CallError.callError("Datatype <" + syntaxDatatype.getName() + "> at line " + lineNumber + " is not a valid float.");
                    }

                    return data;
                }
            }

            if (syntaxDatatype.getType() == Boolean.class && argument.startsWith(syntaxDatatype.getName())) {
                if (argument.startsWith(syntaxDatatype.getName() + "<") && argument.endsWith(">")) {
                    String data = argument.substring(syntaxDatatype.getName().length() + 1, argument.length() - 1);

                    Boolean bool = Boolean.FALSE;
                    try {
                        bool = Boolean.valueOf(data);
                    } catch (Exception e) {
                        CallError.callError("Datatype <" + syntaxDatatype.getName() + "> at line " + lineNumber + " is not a boolean.");
                    }

                    return bool ? "true" : "false";
                }
            }
        }

        CallError.callError("Datatype <" + argument + "> at line " + lineNumber + " does NOT make sense :(");
        return null;
    }
}
