package rip.shuka.core.logic.functions.Console;

import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.datatypes.types.Any;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Null;

public class Daijoubu extends Function {
    public Daijoubu() {
        super("daijoubu", new Parameter[] {
                new Parameter(null, new Datatype[] { new Any()}, "The text to moan but it's green")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        System.out.println("\u001B[32m" + args[0].value() + "\u001B[0m");
        return new DatatypeObject(new Null(), null);
    }
}
