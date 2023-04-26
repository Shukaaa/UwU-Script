package rip.shuka.core.logic.functions.Console;

import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.LogicElement;
import rip.shuka.core.logic.datatypes.types.Any;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Null;

public class Moan extends LogicElement {
    public Moan() {
        super("moan", new Parameter[] {
                new Parameter(null, new Datatype[] { new Any()}, "The text to moan")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        System.out.println(args[0].value());
        return new DatatypeObject(new Null(), null);
    }
}
