package rip.shuka.core.logic.functions.Math.FH;

import rip.shuka.core.logic.LogicElement;
import rip.shuka.core.logic.functions.FunctionHolder;
import rip.shuka.core.logic.functions.Math.Add;

public class MathFH extends FunctionHolder {
    public MathFH() {
        super("math", new LogicElement[]{
            new Add()
        });
    }
}
