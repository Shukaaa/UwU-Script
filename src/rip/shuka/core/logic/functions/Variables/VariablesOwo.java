package rip.shuka.core.logic.functions.Variables;

import rip.shuka.core.utils.ErrorUtil;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.logic.LogicElement;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.variables.Variable;
import rip.shuka.core.logic.variables.VariableStore;

public class VariablesOwo extends LogicElement {
    public VariablesOwo() {
        super("owo", new Parameter[] {
                new Parameter(null, new Datatype[] { new String() }, "The name of the variable"),
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        Variable variable = VariableStore.getInstance().getVariable(args[0].value());
        try {
            return variable.datatypeObject();
        } catch (NullPointerException e) {
            ErrorUtil.callError("Variable <" + args[0].value() + "> has not been initialized");
            return null;
        }
    }
}
