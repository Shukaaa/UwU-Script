package rip.shuka.core.logic.functions.ControlStructures;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Boolean;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

public class If extends Function {
    public If() {
        super("if", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Boolean() }, "if statement")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        // Main Logic in interpreter
        return null;
    }
}
