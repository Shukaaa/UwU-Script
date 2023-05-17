package rip.shuka.core.logic.functions.Logic;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Any;
import rip.shuka.core.logic.datatypes.types.Boolean;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

import java.util.Objects;

public class Is extends Function {
    public Is() {
        super("is", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Any() }, "First bool for comparing"),
                new Parameter(null, new Datatype[]{ new Any() }, "Second bool for comparing")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        String x = args[0].value();
        String y = args[1].value();

        return new DatatypeObject(new Boolean(), java.lang.Boolean.toString(Objects.equals(x, y)));
    }
}
