package rip.shuka.core.logic.functions.Math;

import rip.shuka.core.logic.LogicElement;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Float;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.parameter.Parameter;

import java.util.Objects;

public class Mod extends LogicElement {
    public Mod() {
        super("mod", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Float(), new Integer() }, "modulo num 1"),
                new Parameter(null, new Datatype[]{ new Float(), new Integer() }, "modulo num 2")
        });
    }

    public DatatypeObject execute(DatatypeObject[] args) {
        // Check if both args are int, if yes, return value is gonna be an int too
        if (Objects.equals(args[0].datatype().getName(), "int") && Objects.equals(args[1].datatype().getName(), "int")) {
            int x = java.lang.Integer.parseInt(args[0].value());
            int y = java.lang.Integer.parseInt(args[1].value());

            return new DatatypeObject(new Integer(), java.lang.Integer.toString(x%y));
        }

        double x = Double.parseDouble(args[0].value());
        double y = Double.parseDouble(args[1].value());

        return new DatatypeObject(new Float(), Double.toString(x%y));
    }
}
