package rip.shuka.core.logic.functions.Logic;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Boolean;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

public class Not extends Function {
    public Not() {
        super("not", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Boolean() }, "First bool to negative")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        boolean x = java.lang.Boolean.parseBoolean(args[0].value());

        return new DatatypeObject(new Boolean(), java.lang.Boolean.toString(!x));
    }
}
