package rip.shuka.core.logic.functions.Incrementer;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.incrementer.Incrementer;
import rip.shuka.core.logic.incrementer.IncrementerStore;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.utils.ErrorUtil;

public class Get extends Function {
    public Get() {
        super("get", new Parameter[]{
                new Parameter(null, new Datatype[]{ new String() }, "name of incrementer to get value of")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        Incrementer incrementer = IncrementerStore.getInstance().getIncrementer(args[0].value());

        try {
            return new DatatypeObject(new Integer(), java.lang.Integer.toString(incrementer.value()));
        } catch (NullPointerException e) {
            ErrorUtil.callError("Incrementer <" + args[0].value() + "> has not been initialized.");
        }

        return null;
    }
}
