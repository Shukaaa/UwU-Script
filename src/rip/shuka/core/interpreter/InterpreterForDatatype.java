package rip.shuka.core.interpreter;

import rip.shuka.core.utils.ErrorUtil;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterpreterForDatatype {
    public static DatatypeObject interpretDatatype(String argument, int lineNumber) {
        Pattern pattern = Pattern.compile("^\\w+<[^<>]*>$");
        Matcher matcher = pattern.matcher(argument);

        if (!matcher.find()) {
            return null;
        }

        if (argument.startsWith("str")) {
            return interpretString(new rip.shuka.core.logic.datatypes.types.String(), argument);
        }

        if (argument.startsWith("int")) {
            return interpretInteger(new rip.shuka.core.logic.datatypes.types.Integer(), argument, lineNumber);
        }

        if (argument.startsWith("float")) {
            return interpretFloat(new rip.shuka.core.logic.datatypes.types.Float(), argument, lineNumber);
        }

        if (argument.startsWith("bool")) {
            return interpretBoolean(new rip.shuka.core.logic.datatypes.types.Boolean(), argument, lineNumber);
        }

        if (argument.startsWith("any")) {
            return interpretAny(new rip.shuka.core.logic.datatypes.types.Any(), argument);
        }

        if (argument.startsWith("null")) {
            return interpretNull(new rip.shuka.core.logic.datatypes.types.Null());
        }

        return null;
    }

    private static DatatypeObject interpretInteger(Datatype datatype, String argument, int lineNumber) {
        String data = argument.substring(datatype.getName().length() + 1, argument.length() - 1);

        try {
            Integer.parseInt(data);
        } catch (NumberFormatException e) {
            ErrorUtil.callError(argument + " at line " + lineNumber + " is not a valid integer.");
        }
        return new DatatypeObject(datatype, data);
    }

    private static DatatypeObject interpretString(Datatype datatype, String argument) {
        return new DatatypeObject(datatype, argument.substring(datatype.getName().length() + 1, argument.length() - 1));
    }

    private static DatatypeObject interpretFloat(Datatype datatype, String argument, int lineNumber) {
        String data = argument.substring(datatype.getName().length() + 1, argument.length() - 1);

        try {
            Double.parseDouble(data);
        } catch (NumberFormatException e) {
            ErrorUtil.callError(argument + " at line " + lineNumber + " is not a valid float.");
        }

        return new DatatypeObject(datatype, data);
    }

    private static DatatypeObject interpretBoolean(Datatype datatype, String argument, int lineNumber) {
        String data = argument.substring(datatype.getName().length() + 1, argument.length() - 1);
        switch (data) {
            case "true" -> {
                return new DatatypeObject(datatype, "true");
            }
            case "false" -> {
                return new DatatypeObject(datatype, "false");
            }
            default -> ErrorUtil.callError(argument + " at line " + lineNumber + " is not a boolean.");
        }

        return null;
    }

    private static DatatypeObject interpretAny(Datatype datatype, String argument) {
        return new DatatypeObject(datatype, argument.substring(datatype.getName().length() + 1, argument.length() - 1));
    }

    private static DatatypeObject interpretNull(Datatype datatype) {
        return new DatatypeObject(datatype, null);
    }
}
