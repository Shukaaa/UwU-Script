package rip.shuka.core.logic.functions.Arrays;

import rip.shuka.core.logic.arrays.Array;
import rip.shuka.core.logic.arrays.ArrayStore;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

public class Length extends Function {
        public Length() {
            super("len", new Parameter[] {
                    new Parameter(null, new Datatype[] { new String() }, "name of array")
            });
        }

        @Override
        public DatatypeObject execute(DatatypeObject[] args) {
            Array array = ArrayStore.getInstance().getArray(args[0].value());

            return new DatatypeObject(new Integer(), java.lang.String.valueOf(array.datatypeObjects().size()));
        }
}
