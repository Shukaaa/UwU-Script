package rip.shuka.core.logic.functions.Cast;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Any;
import rip.shuka.core.logic.datatypes.types.Boolean;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.utils.ErrorUtil;

import java.util.Objects;

public class Bool extends Function {
    public Bool() {
        super("bool", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Any() }, "data to bool")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        String x = args[0].value();

        // Int to Bool
        if (Objects.equals(args[0].datatype().getName(), "int")) {
            switch (x) {
                case "0" -> { return new DatatypeObject(new Boolean(), "false"); }
                case "1" -> { return new DatatypeObject(new Boolean(), "true"); }
                default -> ErrorUtil.callError("You can only cast Int 0 and 1 to bool but you tried <" + x + ">");
            }
        }

        // Basic Java Casting
        try {
            boolean y = java.lang.Boolean.parseBoolean(x);
            return new DatatypeObject(new Boolean(), java.lang.Boolean.toString(y));
        } catch (Exception e) {
            ErrorUtil.callError("Can't convert <" + x + "> to <Bool> because it's not a valid Boolean.");
            return null;
        }
    }
}
