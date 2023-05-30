package rip.shuka.core.logic.functions.Math;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

public class Inc extends Function {
    public Inc() {
        super("inc", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Integer() }, "number to increment"),
        });
    }

    public DatatypeObject execute(DatatypeObject[] args) {
        int x = java.lang.Integer.parseInt(args[0].value());

        return new DatatypeObject(new Integer(), java.lang.Integer.toString(x + 1));
    }
}
