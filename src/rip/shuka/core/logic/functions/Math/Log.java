package rip.shuka.core.logic.functions.Math;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Float;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

public class Log extends Function {
    public Log() {
        super("log", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Float(), new Integer() }, "base"),
                new Parameter(null, new Datatype[]{ new Float(), new Integer() }, "num for log")
        });
    }

    public DatatypeObject execute(DatatypeObject[] args) {
        double base = Double.parseDouble(args[0].value());
        double x = Double.parseDouble(args[1].value());

        return new DatatypeObject(new Float(), Double.toString(Math.log(x) / Math.log(base)));
    }
}
