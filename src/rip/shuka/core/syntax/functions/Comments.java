package rip.shuka.core.syntax.functions;

import rip.shuka.core.syntax.Parameter;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;
import rip.shuka.core.syntax.datatypes.Null;

public class Comments extends SyntaxElement<Null> {
    public Comments() {
        super("#", SyntaxTypes.COMMENT, new Parameter[]{});
    }

    @Override
    public Null execute(String[] args) {
        // Do nothing
        return new Null();
    }
}
