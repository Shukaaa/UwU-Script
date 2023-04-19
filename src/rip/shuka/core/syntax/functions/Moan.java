package rip.shuka.core.syntax.functions;

import rip.shuka.core.syntax.Parameter;
import rip.shuka.core.syntax.SyntaxDatatype;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;
import rip.shuka.core.syntax.datatypes.Any;

public class Moan extends SyntaxElement {
    public Moan() {
        super("moan", SyntaxTypes.FUNCTION, new Parameter[] {
                new Parameter("", new SyntaxDatatype[] { new Any()}, "The text to moan")
        });
    }

    @Override
    public void execute(String[] args) {
        System.out.println(args[0]);
    }
}
