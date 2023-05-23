package rip.shuka.core.logic.functions.Cast;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Any;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

public class Str extends Function {
    public Str() {
        super("str", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Any() }, "data to str")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        return new DatatypeObject(new String(), args[0].value());
    }
}
