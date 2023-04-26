package rip.shuka.core.logic.functions.Basics;

import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.logic.LogicElement;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Null;

public class Comments extends LogicElement {
    public Comments() {
        super("//", new Parameter[]{});
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        // Do nothing
        return new DatatypeObject(new Null(), null);
    }
}
