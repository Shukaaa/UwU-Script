package rip.shuka.core.logic.functions.Func;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

public class Param extends Function {
    public Param() {
        super("param", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Integer() }, "index of the parameter"),
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        // Logic in interpreter
        return null;
    }
}
