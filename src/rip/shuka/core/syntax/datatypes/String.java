package rip.shuka.core.syntax.datatypes;

import rip.shuka.core.syntax.SyntaxDatatype;

public class String extends SyntaxDatatype<java.lang.String> {
    public String() {
        super("str", java.lang.String.class);
    }
}
