package rip.shuka.core.logic.functions.Math;

import rip.shuka.core.logic.LogicElement;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Boolean;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.parameter.Parameter;

public class Even extends LogicElement {
    public Even() {
        super("even", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Integer() }, "check if even")
        });
    }

    public DatatypeObject execute(DatatypeObject[] args) {
        // Check if both args are int, if yes, return value is gonna be an int too
        int x = java.lang.Integer.parseInt(args[0].value());

        return new DatatypeObject(new Boolean(), java.lang.Boolean.toString(x%2 == 0));
    }
}
