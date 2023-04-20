package rip.shuka.core.interpreter;

import rip.shuka.core.error.CallError;
import rip.shuka.core.syntax.Datatype;
import rip.shuka.core.syntax.SyntaxVars;
import rip.shuka.core.syntax.datatypes.DatatypeObject.DatatypeObject;

import java.util.Objects;

public class InterpreterForDatatype {
    public static DatatypeObject interpretDatatype(String argument, int lineNumber) {
        if (!argument.contains("<") && !argument.contains(">")) {
            return null;
        }

        // Check each syntaxDatatype
        for (Datatype syntaxDatatype : SyntaxVars.syntaxDatatypes) {
            if (syntaxDatatype.getType() == Integer.class && argument.startsWith(syntaxDatatype.getName())) {
                if (argument.startsWith(syntaxDatatype.getName() + "<") && argument.endsWith(">")) {
                    String data = argument.substring(syntaxDatatype.getName().length() + 1, argument.length() - 1);

                    try {
                        Integer.parseInt(data);
                    } catch (NumberFormatException e) {
                        CallError.callError("Datatype <" + syntaxDatatype.getName() + "> at line " + lineNumber + " is not a valid integer.");
                    }
                    return new DatatypeObject(syntaxDatatype, data);
                }
            }

            if (syntaxDatatype.getType() == String.class && (argument.startsWith(syntaxDatatype.getName())) && Objects.equals(syntaxDatatype.getName(), "str")) {
                if (argument.startsWith(syntaxDatatype.getName() + "<") && argument.endsWith(">")) {
                    return new DatatypeObject(syntaxDatatype, argument.substring(syntaxDatatype.getName().length() + 1, argument.length() - 1));
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

                    return new DatatypeObject(syntaxDatatype, data);
                }
            }

            if (syntaxDatatype.getType() == Boolean.class && argument.startsWith(syntaxDatatype.getName())) {
                if (argument.startsWith(syntaxDatatype.getName() + "<") && argument.endsWith(">")) {
                    String data = argument.substring(syntaxDatatype.getName().length() + 1, argument.length() - 1);

                    boolean bool = Boolean.FALSE;
                    try {
                        bool = Boolean.parseBoolean(data);
                    } catch (Exception e) {
                        CallError.callError("Datatype <" + syntaxDatatype.getName() + "> at line " + lineNumber + " is not a boolean.");
                    }

                    return new DatatypeObject(syntaxDatatype, bool ? "true" : "false");
                }
            }

            if (syntaxDatatype.getType() == String.class && (argument.startsWith(syntaxDatatype.getName())) && Objects.equals(syntaxDatatype.getName(), "any")) {
                if (argument.startsWith(syntaxDatatype.getName() + "<") && argument.endsWith(">")) {
                    return new DatatypeObject(syntaxDatatype, argument.substring(syntaxDatatype.getName().length() + 1, argument.length() - 1));
                }
            }

            if (syntaxDatatype.getType() == null && (argument.startsWith(syntaxDatatype.getName()))) {
                if (argument.startsWith(syntaxDatatype.getName() + "<") && argument.endsWith(">")) {
                    return new DatatypeObject(syntaxDatatype, null);
                }
            }
        }

        return null;
    }
}
