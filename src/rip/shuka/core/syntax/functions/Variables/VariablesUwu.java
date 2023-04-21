package rip.shuka.core.syntax.functions.Variables;

import rip.shuka.core.syntax.Datatype;
import rip.shuka.core.syntax.Parameter;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;
import rip.shuka.core.syntax.datatypes.Any;
import rip.shuka.core.syntax.datatypes.DatatypeObject.DatatypeObject;
import rip.shuka.core.syntax.datatypes.String;
import rip.shuka.core.syntax.variables.Variable;
import rip.shuka.core.syntax.variables.VariableStore;

public class VariablesUwu extends SyntaxElement {
    public VariablesUwu() {
        super("uwu", SyntaxTypes.FUNCTION, new Parameter[] {
                new Parameter(null, new Datatype[] { new String() }, "The name of the variable"),
                new Parameter(null, new Datatype[] { new Any() }, "The value of the variable")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        VariableStore.getInstance().addVariable(new Variable(args[0].value(), args[1]));
        return new DatatypeObject(args[1].datatype(), args[0].value());
    }
}
