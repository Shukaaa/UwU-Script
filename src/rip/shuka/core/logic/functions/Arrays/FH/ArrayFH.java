package rip.shuka.core.logic.functions.Arrays.FH;

import rip.shuka.core.logic.functions.Arrays.*;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.functions.FunctionHolder;

public class ArrayFH extends FunctionHolder {
    public ArrayFH() {
        super("arr", new Function[]{
                new Create(),
                new Add(),
                new Get(),
                new Replace(),
                new Rem(),
                new Moan(),
                new Length(),
                new Stringify()
        });
    }
}
