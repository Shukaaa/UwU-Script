package rip.shuka.core.logic.functions.Console;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Any;
import rip.shuka.core.logic.datatypes.types.Null;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.utils.ColorUtil;
import rip.shuka.core.utils.StringCorrectorUtil;

public class Zenitsu extends Function {
    public Zenitsu() {
        super("zenitsu", new Parameter[] {
                new Parameter(null, new Datatype[] { new Any()}, "The text to moan but it's yellow")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        System.out.println(ColorUtil.YELLOW + StringCorrectorUtil.correctForConsole(args[0].value()) + ColorUtil.RESET);
        return new DatatypeObject(new Null(), null);
    }
}
