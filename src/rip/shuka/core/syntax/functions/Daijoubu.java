package rip.shuka.core.syntax.functions;

import rip.shuka.core.syntax.Parameter;
import rip.shuka.core.syntax.SyntaxDatatype;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;
import rip.shuka.core.syntax.datatypes.Any;

public class Daijoubu extends SyntaxElement {
    public Daijoubu() {
        super("daijoubu", SyntaxTypes.FUNCTION, new Parameter[] {
                new Parameter("", new SyntaxDatatype[] { new Any()}, "The text to moan but it's Daijoubu")
        });
    }

    @Override
    public void execute(String[] args) {
        System.out.println("\u001B[32m" + args[0] + "\u001B[0m");
    }
}
