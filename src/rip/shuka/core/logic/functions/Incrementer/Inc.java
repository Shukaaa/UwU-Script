package rip.shuka.core.logic.functions.Incrementer;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Null;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.incrementer.Incrementer;
import rip.shuka.core.logic.incrementer.IncrementerStore;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.utils.ErrorUtil;

public class Inc extends Function {
    public Inc() {
        super("inc", new Parameter[]{
                new Parameter(null, new Datatype[]{ new String() }, "incrementer name to increment")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        Incrementer incrementer = IncrementerStore.getInstance().getIncrementer(args[0].value());

        try {
            incrementer.increment();
        } catch (NullPointerException e) {
            ErrorUtil.callError("Incrementer <" + args[0].value() + "> has not been initialized.");
        }

        IncrementerStore.getInstance().addIncrementer(incrementer);
        return new DatatypeObject(new Null(), null);
    }
}
