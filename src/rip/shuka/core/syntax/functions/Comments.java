package rip.shuka.core.syntax.functions;

import rip.shuka.core.syntax.Parameter;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;
import rip.shuka.core.syntax.datatypes.DatatypeObject.DatatypeObject;
import rip.shuka.core.syntax.datatypes.Null;

public class Comments extends SyntaxElement {
    public Comments() {
        super("#", SyntaxTypes.COMMENT, new Parameter[]{});
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        // Do nothing
        return new DatatypeObject(new Null(), null);
    }
}
