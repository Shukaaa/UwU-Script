package rip.shuka.core.logic.functions.Func;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Any;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

public class New extends Function {
    public New() {
        super("new", new Parameter[]{
                new Parameter(null, new Datatype[]{ new String() }, "name of the function"),
                new Parameter(null, new Datatype[]{ new Any() }, "parameters of the function"),
        });

        getParameters()[1].beInfinityParam();
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        // Logic in interpreter
        return null;
    }
}
