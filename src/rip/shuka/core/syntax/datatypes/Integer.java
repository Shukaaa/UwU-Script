package rip.shuka.core.syntax.datatypes;

import rip.shuka.core.syntax.SyntaxDatatype;

public class Integer extends SyntaxDatatype<java.lang.Integer> {
    public Integer() {
        super("int", java.lang.Integer.class);
    }
}
