package rip.shuka.core.logic.functions.Incrementer.FH;

import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.functions.FunctionHolder;
import rip.shuka.core.logic.functions.Incrementer.Dec;
import rip.shuka.core.logic.functions.Incrementer.Get;
import rip.shuka.core.logic.functions.Incrementer.Inc;
import rip.shuka.core.logic.functions.Incrementer.Init;

public class IncrementerFH extends FunctionHolder {
    public IncrementerFH() {
        super("i", new Function[]{
            new Init(),
            new Inc(),
            new Get(),
            new Dec()
        });
    }
}
