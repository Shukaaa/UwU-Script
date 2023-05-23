package rip.shuka.core.logic.functions.Cast.FH;

import rip.shuka.core.logic.functions.Cast.Bool;
import rip.shuka.core.logic.functions.Cast.Float;
import rip.shuka.core.logic.functions.Cast.Int;
import rip.shuka.core.logic.functions.Cast.Str;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.functions.FunctionHolder;

public class CastFH extends FunctionHolder {
    public CastFH() {
        super("cast", new Function[]{
                new Int(),
                new Bool(),
                new Str(),
                new Float()
        });
    }
}
