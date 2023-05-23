package rip.shuka.core.logic.functions.Cast;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Any;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.utils.ErrorUtil;

public class Float extends Function {
    public Float() {
        super("float", new Parameter[]{
                new Parameter(null, new Datatype[]{ new Any() }, "data to float")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        String x = args[0].value();

        // Basic Java Casting
        try {
            double y = java.lang.Double.parseDouble(x);
            return new DatatypeObject(new rip.shuka.core.logic.datatypes.types.Float(), java.lang.Double.toString(y));
        } catch (Exception e) {
            ErrorUtil.callError("Can't convert <" + x + "> to <Float> because it's not a valid floating number.");
            return null;
        }
    }
}
