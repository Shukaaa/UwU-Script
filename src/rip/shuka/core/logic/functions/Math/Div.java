package rip.shuka.core.logic.functions.Math;

import rip.shuka.core.logic.LogicElement;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Float;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.parameter.Parameter;

public class Div extends LogicElement {
    public Div() {
        super("div", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Float(), new Integer() }, "division num 1"),
                new Parameter(null, new Datatype[]{ new Float(), new Integer() }, "division num 2")
        });
    }

    public DatatypeObject execute(DatatypeObject[] args) {
        double x = Double.parseDouble(args[0].value());
        double y = Double.parseDouble(args[1].value());

        return new DatatypeObject(new Float(), Double.toString(x/y));
    }
}
