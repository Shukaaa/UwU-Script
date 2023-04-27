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

        DatatypeObject result;
        for (Datatype datatype : LogicCollection.datatypes) {
            result = interpretString(datatype, argument);
            if (result != null) { return result; }

            result = interpretInteger(datatype, argument, lineNumber);
            if (result != null) { return result; }

            result = interpretFloat(datatype, argument, lineNumber);
            if (result != null) { return result; }

            result = interpretBoolean(datatype, argument, lineNumber);
            if (result != null) { return result; }

            result = interpretAny(datatype, argument);
            if (result != null) { return result; }

            result = interpretNull(datatype, argument);
            if (result != null) { return result; }
        }

        return null;
    }

    private static DatatypeObject interpretInteger(Datatype datatype, String argument, int lineNumber) {
        if (datatype.getType() == Integer.class && argument.startsWith(datatype.getName())) {
            if (argument.startsWith(datatype.getName() + "<") && argument.endsWith(">")) {
                String data = argument.substring(datatype.getName().length() + 1, argument.length() - 1);

                try {
                    Integer.parseInt(data);
                } catch (NumberFormatException e) {
                    ErrorUtil.callError("Datatype <" + datatype.getName() + "> at line " + lineNumber + " is not a valid integer.");
                }
                return new DatatypeObject(datatype, data);
            }
        }

        return null;
    }

    private static DatatypeObject interpretString(Datatype datatype, String argument) {
        if (datatype.getType() == String.class && (argument.startsWith(datatype.getName())) && Objects.equals(datatype.getName(), "str")) {
            if (argument.startsWith(datatype.getName() + "<") && argument.endsWith(">")) {
                return new DatatypeObject(datatype, argument.substring(datatype.getName().length() + 1, argument.length() - 1));
            }
        }

        return null;
    }

    private static DatatypeObject interpretFloat(Datatype datatype, String argument, int lineNumber) {
        if (datatype.getType() == Float.class && argument.startsWith(datatype.getName())) {
            if (argument.startsWith(datatype.getName() + "<") && argument.endsWith(">")) {
                String data = argument.substring(datatype.getName().length() + 1, argument.length() - 1);

                try {
                    Double.parseDouble(data);
                } catch (NumberFormatException e) {
                    ErrorUtil.callError("Datatype <" + datatype.getName() + "> at line " + lineNumber + " is not a valid float.");
                }

                return new DatatypeObject(datatype, data);
            }
        }

        return null;
    }

    private static DatatypeObject interpretBoolean(Datatype datatype, String argument, int lineNumber) {
        if (datatype.getType() == Boolean.class && argument.startsWith(datatype.getName())) {
            if (argument.startsWith(datatype.getName() + "<") && argument.endsWith(">")) {
                String data = argument.substring(datatype.getName().length() + 1, argument.length() - 1);

                boolean bool = Boolean.FALSE;
                try {
                    bool = Boolean.parseBoolean(data);
                } catch (Exception e) {
                    ErrorUtil.callError("Datatype <" + datatype.getName() + "> at line " + lineNumber + " is not a boolean.");
                }

                return new DatatypeObject(datatype, bool ? "true" : "false");
            }
        }

        return null;
    }

    private static DatatypeObject interpretAny(Datatype datatype, String argument) {
        if (datatype.getType() == String.class && (argument.startsWith(datatype.getName())) && Objects.equals(datatype.getName(), "any")) {
            if (argument.startsWith(datatype.getName() + "<") && argument.endsWith(">")) {
                return new DatatypeObject(datatype, argument.substring(datatype.getName().length() + 1, argument.length() - 1));
            }
        }

        return null;
    }

    private static DatatypeObject interpretNull(Datatype datatype, String argument) {
        if (datatype.getType() == null && (argument.startsWith(datatype.getName()))) {
            if (argument.startsWith(datatype.getName() + "<") && argument.endsWith(">")) {
                return new DatatypeObject(datatype, null);
            }
        }

        return null;
    }
}
