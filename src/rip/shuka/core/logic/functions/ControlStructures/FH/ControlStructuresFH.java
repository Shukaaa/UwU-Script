package rip.shuka.core.logic.functions.ControlStructures.FH;

import rip.shuka.core.logic.functions.ControlStructures.Else;
import rip.shuka.core.logic.functions.ControlStructures.If;
import rip.shuka.core.logic.functions.ControlStructures.IfEnds;
import rip.shuka.core.logic.functions.FunctionHolder;

public class ControlStructuresFH extends FunctionHolder {
    public ControlStructuresFH() {
        super("cs", new rip.shuka.core.logic.functions.Function[]{
                new If(),
                new IfEnds(),
                new Else()
        });
    }
}
