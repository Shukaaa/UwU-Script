package rip.shuka.core.logic.functions.Console.FH;

import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.functions.Console.Daijoubu;
import rip.shuka.core.logic.functions.Console.Error;
import rip.shuka.core.logic.functions.Console.Moan;
import rip.shuka.core.logic.functions.FunctionHolder;

public class ConsoleFH extends FunctionHolder {
    public ConsoleFH() {
        super("console", new Function[]{
                new Daijoubu(),
                new Error(),
                new Moan()
        });
    }
}
