package rip.shuka.core.logic.functions.Arrays;

import rip.shuka.core.logic.arrays.Array;
import rip.shuka.core.logic.arrays.ArrayStore;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

public class Stringify extends Function {
        public Stringify() {
            super("stringify", new Parameter[] {
                    new Parameter(null, new Datatype[] { new String() }, "name of array"),
                    new Parameter(null, new Datatype[] { new String() }, "delimiter")
            });
        }

        @Override
        public DatatypeObject execute(DatatypeObject[] args) {
            Array array = ArrayStore.getInstance().getArray(args[0].value());
            StringBuilder builder = new StringBuilder();

            for (DatatypeObject datatypeObject : array.datatypeObjects()) {
                builder.append(datatypeObject.value()).append(args[1].value());
            }

            return new DatatypeObject(new String(), builder.substring(0, builder.toString().length() - args[1].value().length()));
        }
}
