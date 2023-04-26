package rip.shuka.core.logic.functions.System.FH;

import rip.shuka.core.logic.LogicElement;
import rip.shuka.core.logic.functions.FunctionHolder;
import rip.shuka.core.logic.functions.System.Sayonara;

public class SystemFH extends FunctionHolder {
    public SystemFH() {
        super("sys", new LogicElement[]{
                new Sayonara()
        });
    }
}
