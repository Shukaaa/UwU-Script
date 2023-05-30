package rip.shuka.core.logic.functions.Loop.FH;

import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.functions.FunctionHolder;
import rip.shuka.core.logic.functions.Loop.Repeat;

public class LoopFH extends FunctionHolder {
    public LoopFH() {
        super("loop", new Function[]{
                new Repeat(),
        });
    }
}
