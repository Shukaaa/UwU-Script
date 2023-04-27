package rip.shuka.core.logic.functions.System.FH;

import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.functions.FunctionHolder;
import rip.shuka.core.logic.functions.System.Sayonara;

public class SystemFH extends FunctionHolder {
    public SystemFH() {
        super("sys", new Function[]{
                new Sayonara()
        });
    }
}
