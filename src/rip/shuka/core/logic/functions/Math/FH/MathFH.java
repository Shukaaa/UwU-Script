package rip.shuka.core.logic.functions.Math.FH;

import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.functions.FunctionHolder;
import rip.shuka.core.logic.functions.Math.*;

public class MathFH extends FunctionHolder {
    public MathFH() {
        super("math", new Function[]{
                // Basic Math
                new Add(),
                new Sub(),
                new Multi(),
                new Div(),
                new Mod(),

                // Advanced Math
                new Pow(),
                new Sqrt(),
                new Cbrt(),
                new Log(),
                new Sin(),
                new Cos(),
                new Tan(),

                // Logic Math
                new Greater(),
                new GreaterIs(),
                new Less(),
                new LessIs(),
                new Is(),

                // Math Helper
                new Even(),
                new Odd(),
                new Inc(),
                new Dec(),
        });
    }
}
