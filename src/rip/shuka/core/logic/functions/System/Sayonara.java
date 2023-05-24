package rip.shuka.core.logic.functions.System;

import rip.shuka.core.utils.StringCorrectorUtil;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Null;
import rip.shuka.core.logic.datatypes.types.String;

public class Sayonara extends Function {
    public Sayonara() {
        super("sayonara",new Parameter[] {
                new Parameter(new DatatypeObject(new String(), ""), new Datatype[] { new String() }, "Optional: Message after Exit"),
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        System.out.println(StringCorrectorUtil.correctForConsole(args[0].value()));
        System.exit(0);
        return new DatatypeObject(new Null(), null);
    }
}
