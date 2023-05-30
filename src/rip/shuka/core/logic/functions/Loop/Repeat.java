package rip.shuka.core.logic.functions.Loop;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

public class Repeat extends Function {
    public Repeat() {
        super("repeat", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Integer() }, "number of times to repeat")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        // Main Logic in Interpreter.java
        return null;
    }
}
