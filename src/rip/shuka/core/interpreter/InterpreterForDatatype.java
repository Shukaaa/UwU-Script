package rip.shuka.core.interpreter;

import rip.shuka.core.utils.ErrorUtil;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.LogicCollection;
import rip.shuka.core.logic.datatypes.DatatypeObject;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterpreterForDatatype {
    public static DatatypeObject interpretDatatype(String argument, int lineNumber) {
        Pattern pattern = Pattern.compile("^\\w+<[^<>]*>$");
        Matcher matcher = pattern.matcher(argument);

        if (!matcher.find()) {
            return null;
        }

        // Check each syntaxDatatype
        for (Datatype syntaxDatatype : LogicCollection.datatypes) {
            if (syntaxDatatype.getType() == Integer.class && argument.startsWith(syntaxDatatype.getName())) {
                if (argument.startsWith(syntaxDatatype.getName() + "<") && argument.endsWith(">")) {
                    String data = argument.substring(syntaxDatatype.getName().length() + 1, argument.length() - 1);

                    try {
                        Integer.parseInt(data);
                    } catch (NumberFormatException e) {
                        ErrorUtil.callError("Datatype <" + syntaxDatatype.getName() + "> at line " + lineNumber + " is not a valid integer.");
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
                        ErrorUtil.callError("Datatype <" + syntaxDatatype.getName() + "> at line " + lineNumber + " is not a valid float.");
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
                        ErrorUtil.callError("Datatype <" + syntaxDatatype.getName() + "> at line " + lineNumber + " is not a boolean.");
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
