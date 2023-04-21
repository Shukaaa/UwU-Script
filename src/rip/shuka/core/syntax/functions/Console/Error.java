package rip.shuka.core.syntax.functions.Console;

import rip.shuka.core.syntax.Parameter;
import rip.shuka.core.syntax.Datatype;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;
import rip.shuka.core.syntax.datatypes.Any;
import rip.shuka.core.syntax.datatypes.DatatypeObject.DatatypeObject;
import rip.shuka.core.syntax.datatypes.Null;

public class Error extends SyntaxElement {
    public Error() {
        super("error", SyntaxTypes.FUNCTION, new Parameter[] {
                new Parameter(null, new Datatype[] { new Any() }, "The text to display as an error")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        System.err.println(args[0].value());
        return new DatatypeObject(new Null(), null);
    }
}
