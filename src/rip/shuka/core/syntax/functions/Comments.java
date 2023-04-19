package rip.shuka.core.syntax.functions;

import rip.shuka.core.syntax.Parameter;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;

public class Comments extends SyntaxElement {
    public Comments() {
        super("#", SyntaxTypes.COMMENT, new Parameter[]{});
    }

    @Override
    public void execute(String[] args) {
        // Do nothing
    }
}
