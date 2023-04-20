package rip.shuka.core.syntax.functions;

import rip.shuka.core.syntax.Parameter;
import rip.shuka.core.syntax.Datatype;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;
import rip.shuka.core.syntax.datatypes.Any;
import rip.shuka.core.syntax.datatypes.DatatypeObject.DatatypeObject;
import rip.shuka.core.syntax.datatypes.Null;

public class Moan extends SyntaxElement {
    public Moan() {
        super("moan", SyntaxTypes.FUNCTION, new Parameter[] {
                new Parameter("", new Datatype[] { new Any()}, "The text to moan")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        System.out.println(args[0].value());
        return new DatatypeObject(new Null(), null);
    }
}
