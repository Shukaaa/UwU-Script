package rip.shuka.core.syntax.functions;

import rip.shuka.core.syntax.Parameter;
import rip.shuka.core.syntax.SyntaxDatatype;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;
import rip.shuka.core.syntax.datatypes.Any;

public class Error extends SyntaxElement {
    public Error() {
        super("error", SyntaxTypes.FUNCTION, new Parameter[] {
                new Parameter("", new SyntaxDatatype[] { new Any() }, "The text to display as an error")
        });
    }

    @Override
    public void execute(String[] args) {
        System.err.println(args[0]);
    }
}
