package rip.shuka.core.logic.functions.Math.FH;

import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.functions.FunctionHolder;
import rip.shuka.core.logic.functions.Math.*;

public class MathFH extends FunctionHolder {
    public MathFH() {
        super("math", new Function[]{
            new Add(),
            new Sub(),
            new Multi(),
            new Div(),
            new Mod(),
            new Even(),
            new Odd(),
            new Pow(),
            new Sqrt(),
            new Cbrt(),
            new Log(),
        });
    }
}
