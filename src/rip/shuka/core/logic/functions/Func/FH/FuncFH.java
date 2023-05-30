package rip.shuka.core.logic.functions.Func.FH;

import rip.shuka.core.logic.functions.Func.End;
import rip.shuka.core.logic.functions.Func.New;
import rip.shuka.core.logic.functions.Func.Param;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.functions.FunctionHolder;

public class FuncFH extends FunctionHolder {
    public FuncFH() {
        super("func", new Function[]{
                new New(),
                new End(),
                new Param()
        });
    }
}
