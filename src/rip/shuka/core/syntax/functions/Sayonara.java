package rip.shuka.core.syntax.functions;

import rip.shuka.core.syntax.Parameter;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;
import rip.shuka.core.syntax.datatypes.DatatypeObject.DatatypeObject;
import rip.shuka.core.syntax.datatypes.Null;

public class Sayonara extends SyntaxElement {
    public Sayonara() {
        super("sayonara", SyntaxTypes.FUNCTION, new Parameter[] {});
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        System.exit(0);
        return new DatatypeObject(new Null(), null);
    }
}
