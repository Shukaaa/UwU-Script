package rip.shuka.core.logic.functions.System;

import rip.shuka.core.corrector.StringCorrector;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.logic.LogicElement;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Null;
import rip.shuka.core.logic.datatypes.types.String;

public class Sayonara extends LogicElement {
    public Sayonara() {
        super("sayonara",new Parameter[] {
                new Parameter("", new Datatype[] { new String() }, "Optional: Message after Exit"),
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        if (args.length > 0) {
            System.out.println(StringCorrector.correctForConsole(args[0].value()));
        }
        System.exit(0);
        return new DatatypeObject(new Null(), null);
    }
}
