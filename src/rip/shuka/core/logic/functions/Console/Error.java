package rip.shuka.core.logic.functions.Console;

import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.datatypes.types.Any;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Null;
import rip.shuka.core.utils.ColorUtil;
import rip.shuka.core.utils.StringCorrectorUtil;

public class Error extends Function {
    public Error() {
        super("error", new Parameter[] {
                new Parameter(null, new Datatype[] { new Any() }, "The text to display as an error")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        System.out.println(ColorUtil.RED + StringCorrectorUtil.correctForConsole(args[0].value()) + ColorUtil.RESET);
        return new DatatypeObject(new Null(), null);
    }
}
