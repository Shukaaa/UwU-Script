package rip.shuka.core.syntax.functions;

import rip.shuka.core.syntax.Parameter;
import rip.shuka.core.syntax.Datatype;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;
import rip.shuka.core.syntax.datatypes.Any;
import rip.shuka.core.syntax.datatypes.Null;

public class Daijoubu extends SyntaxElement<Null> {
    public Daijoubu() {
        super("daijoubu", SyntaxTypes.FUNCTION, new Parameter[] {
                new Parameter("", new Datatype[] { new Any()}, "The text to moan but it's green")
        });
    }

    @Override
    public Null execute(String[] args) {
        System.out.println("\u001B[32m" + args[0] + "\u001B[0m");
        return new Null();
    }
}
