package rip.shuka.core.logic.functions.Func;

import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

public class End extends Function {
    public End() {
        super("end", new Parameter[]{});
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        // Logic in interpreter
        return null;
    }
}
