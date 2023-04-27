package rip.shuka.core.logic.functions.Console.FH;

import rip.shuka.core.logic.functions.Console.Error;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.functions.Console.*;
import rip.shuka.core.logic.functions.FunctionHolder;

public class ConsoleFH extends FunctionHolder {
    public ConsoleFH() {
        super("console", new Function[]{
                new Daijoubu(),
                new Error(),
                new Moan(),
                new Ask(),
                new CherryBlossom(),
                new Zenitsu(),
        });
    }
}
