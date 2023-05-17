package rip.shuka.core.logic.functions.Logic;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Any;
import rip.shuka.core.logic.datatypes.types.Boolean;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

import java.util.Objects;

public class IsType extends Function {
    public IsType() {
        super("is_type", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Any() }, "First bool for comparing"),
                new Parameter(null, new Datatype[]{ new String() }, "Second bool for comparing")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        java.lang.String x = args[0].datatype().getName();
        java.lang.String y = args[1].value();

        return new DatatypeObject(new Boolean(), java.lang.Boolean.toString(Objects.equals(x, y)));
    }
}
