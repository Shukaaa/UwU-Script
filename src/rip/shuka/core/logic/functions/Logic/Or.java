package rip.shuka.core.logic.functions.Logic;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Boolean;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

public class Or extends Function {
    public Or() {
        super("or", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Boolean() }, "First bool for comparing"),
                new Parameter(null, new Datatype[]{ new Boolean() }, "Second bool for comparing")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        boolean x = java.lang.Boolean.parseBoolean(args[0].value());
        boolean y = java.lang.Boolean.parseBoolean(args[1].value());

        return new DatatypeObject(new Boolean(), java.lang.Boolean.toString(x || y));
    }
}
