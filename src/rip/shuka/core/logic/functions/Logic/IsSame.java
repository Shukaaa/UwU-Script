package rip.shuka.core.logic.functions.Logic;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Any;
import rip.shuka.core.logic.datatypes.types.Boolean;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

import java.util.Objects;

public class IsSame extends Function {
    public IsSame() {
        super("is_same", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Any() }, "First bool for comparing"),
                new Parameter(null, new Datatype[]{ new Any() }, "Second bool for comparing")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        String x = args[0].value();
        String y = args[1].value();

        String x2 = args[0].datatype().getName();
        String y2 = args[1].datatype().getName();

        return new DatatypeObject(new Boolean(), java.lang.Boolean.toString(Objects.equals(x, y) && Objects.equals(x2, y2)));
    }
}
