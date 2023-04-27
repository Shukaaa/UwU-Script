package rip.shuka.core.logic.functions.Math;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Float;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

public class Cbrt extends Function {
    public Cbrt() {
        super("cbrt", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Float(), new Integer() }, "num")
        });
    }

    public DatatypeObject execute(DatatypeObject[] args) {
        double x = Double.parseDouble(args[0].value());

        return new DatatypeObject(new Float(), Double.toString(Math.cbrt(x)));
    }
}
