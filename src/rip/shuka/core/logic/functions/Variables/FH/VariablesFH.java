package rip.shuka.core.logic.functions.Variables.FH;

import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.functions.FunctionHolder;
import rip.shuka.core.logic.functions.Variables.VariablesOwo;
import rip.shuka.core.logic.functions.Variables.VariablesUwu;

public class VariablesFH extends FunctionHolder {
    public VariablesFH() {
        super("vars", new Function[]{
                new VariablesOwo(),
                new VariablesUwu()
        });
    }
}
