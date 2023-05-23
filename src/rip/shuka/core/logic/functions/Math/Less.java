package rip.shuka.core.logic.functions.Math;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Boolean;
import rip.shuka.core.logic.datatypes.types.Float;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

public class Less extends Function {
    public Less() {
        super("less", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Float(), new Integer() }, "compare num 1"),
                new Parameter(null, new Datatype[]{ new Float(), new Integer() }, "compare num 2")
        });
    }

    public DatatypeObject execute(DatatypeObject[] args) {
        double x = Double.parseDouble(args[0].value());
        double y = Double.parseDouble(args[1].value());

        return new DatatypeObject(new Boolean(), java.lang.Boolean.toString(x < y));
    }
}
