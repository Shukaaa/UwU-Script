package rip.shuka.core.logic.functions.Arrays;

import rip.shuka.core.logic.arrays.Array;
import rip.shuka.core.logic.arrays.ArrayStore;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Null;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;

import java.util.ArrayList;

public class Create extends Function {
        public Create() {
            super("create", new Parameter[] {
                    new Parameter(null, new Datatype[] { new String() }, "name of array")
            });
        }

        @Override
        public DatatypeObject execute(DatatypeObject[] args) {
            ArrayStore.getInstance().addArray(new Array(args[0].value(), new ArrayList<>()));

            return new DatatypeObject(new Null(), null);
        }
}
