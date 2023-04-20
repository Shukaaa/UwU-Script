package rip.shuka.core.syntax.datatypes;

import rip.shuka.core.syntax.Datatype;

public class Null extends Datatype {
    public Null() {
        super("null", Object.class.getSuperclass());
    }
}
