package rip.shuka.core.syntax.functions;

import rip.shuka.core.syntax.Parameter;
import rip.shuka.core.syntax.Datatype;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;
import rip.shuka.core.syntax.datatypes.Any;
import rip.shuka.core.syntax.datatypes.Null;

public class Error extends SyntaxElement<Null> {
    public Error() {
        super("error", SyntaxTypes.FUNCTION, new Parameter[] {
                new Parameter("", new Datatype[] { new Any() }, "The text to display as an error")
        });
    }

    @Override
    public Null execute(String[] args) {
        System.err.println(args[0]);
        return new Null();
    }
}
