package rip.shuka.core.logic.functions.Incrementer;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.datatypes.types.Null;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.incrementer.Incrementer;
import rip.shuka.core.logic.incrementer.IncrementerStore;
import rip.shuka.core.logic.parameter.Parameter;

public class Init extends Function {
    public Init() {
        super("init", new Parameter[]{
                new Parameter(null, new Datatype[]{ new String() }, "name of incrementer to initialize"),
                new Parameter(new DatatypeObject(new Integer(), "0"), new Datatype[]{ new Integer() }, "value of incrementer to initialize"),
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        Incrementer incrementer = new Incrementer(args[0].value(), java.lang.Integer.parseInt(args[1].value()));
        IncrementerStore.getInstance().addIncrementer(incrementer);

        return new DatatypeObject(new Null(), null);
    }
}
