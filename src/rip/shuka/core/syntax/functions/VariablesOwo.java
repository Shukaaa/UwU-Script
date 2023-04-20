package rip.shuka.core.syntax.functions;

import rip.shuka.core.syntax.Datatype;
import rip.shuka.core.syntax.Parameter;
import rip.shuka.core.syntax.SyntaxElement;
import rip.shuka.core.syntax.SyntaxTypes;
import rip.shuka.core.syntax.datatypes.DatatypeObject.DatatypeObject;
import rip.shuka.core.syntax.datatypes.String;
import rip.shuka.core.syntax.variables.Variable;
import rip.shuka.core.syntax.variables.VariableStore;

public class VariablesOwo extends SyntaxElement {
    public VariablesOwo() {
        super("owo", SyntaxTypes.FUNCTION, new Parameter[] {
                new Parameter("name", new Datatype[] { new String() }, "The name of the variable"),
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        Variable variable = VariableStore.getInstance().getVariable(args[0].value());
        return variable.datatypeObject();
    }
}
