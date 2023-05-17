package rip.shuka.core.logic.functions.Logic.FH;

import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.functions.FunctionHolder;
import rip.shuka.core.logic.functions.Logic.*;

public class LogicFH extends FunctionHolder {
    public LogicFH() {
        super("logic", new Function[]{
                new And(),
                new Or(),
                new Not(),
                new Is(),
                new IsSameType(),
                new IsSame(),
                new IsType()
        });
    }
}
