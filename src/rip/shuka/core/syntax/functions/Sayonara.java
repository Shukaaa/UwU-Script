package rip.shuka.core.syntax.functions;

import rip.shuka.core.syntax.Datatype;
import rip.shuka.core.syntax.Parameter;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;
import rip.shuka.core.syntax.datatypes.DatatypeObject.DatatypeObject;
import rip.shuka.core.syntax.datatypes.Null;
import rip.shuka.core.syntax.datatypes.String;

public class Sayonara extends SyntaxElement {
    public Sayonara() {
        super("sayonara", SyntaxTypes.FUNCTION, new Parameter[] {
                new Parameter("", new Datatype[] { new String() }, "Optional: Message after Exit"),
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        if (args.length > 0) {
            System.out.println(args[0].value());
        }
        System.exit(0);
        return new DatatypeObject(new Null(), null);
    }
}
