package rip.shuka.core.logic.functions.Arrays;

import rip.shuka.core.logic.arrays.Array;
import rip.shuka.core.logic.arrays.ArrayStore;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Null;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.utils.StringCorrectorUtil;

public class Moan extends Function {
        public Moan() {
            super("moan", new Parameter[] {
                    new Parameter(null, new Datatype[] { new String() }, "name of array")
            });
        }

        @Override
        public DatatypeObject execute(DatatypeObject[] args) {
            Array array = ArrayStore.getInstance().getArray(args[0].value());

            int i = 0;
            for (DatatypeObject datatypeObject : array.datatypeObjects()) {
                System.out.println(i + ": " + StringCorrectorUtil.correctForConsole(datatypeObject.value()));
                i++;
            }

            return new DatatypeObject(new Null(), null);
        }
}
