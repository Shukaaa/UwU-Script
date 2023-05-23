package rip.shuka.core.logic.functions.Cast;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Any;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.utils.ErrorUtil;

import java.util.Objects;

public class Int extends Function {
    public Int() {
        super("int", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Any() }, "data to int")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        String x = args[0].value();

        // Bool to Int
        if (Objects.equals(args[0].datatype().getName(), "bool")) {
            return new DatatypeObject(new Integer(), Objects.equals(x, "true") ? "1" : "0");
        }

        // Basic Java Casting
        try {
            int y = java.lang.Integer.parseInt(x);
            return new DatatypeObject(new Integer(), java.lang.Integer.toString(y));
        } catch (Exception e) {
            ErrorUtil.callError("Can't convert <" + x + "> to <Int> because it's not a valid number.");
            return null;
        }
    }
}
