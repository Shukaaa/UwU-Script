package rip.shuka.core.logic.functions.Variables;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.logic.LogicElement;
import rip.shuka.core.logic.datatypes.types.Any;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.variables.Variable;
import rip.shuka.core.logic.variables.VariableStore;

public class VariablesUwu extends LogicElement {
    public VariablesUwu() {
        super("uwu",  new Parameter[] {
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
