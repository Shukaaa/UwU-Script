package rip.shuka.core.logic.functions.Arrays;

import rip.shuka.core.logic.arrays.ArrayStore;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.datatypes.types.Null;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.utils.ErrorUtil;

public class Get extends Function {
        public Get() {
            super("get", new Parameter[] {
                    new Parameter(null, new Datatype[] { new String() }, "name of array"),
                    new Parameter(null, new Datatype[] { new Integer() }, "index to add value to")
            });
        }

        @Override
        public DatatypeObject execute(DatatypeObject[] args) {
            try {
                DatatypeObject value = ArrayStore.getInstance().getArray(args[0].value()).datatypeObjects().get(java.lang.Integer.parseInt(args[1].value()));
                return new DatatypeObject(value.datatype(), value.value());
            } catch (IndexOutOfBoundsException e) {
                ErrorUtil.callError("Array <" + args[0].value() + "> out of bounce.");
            } catch (Error e) {
                ErrorUtil.callError("Array <" + args[0].value() + "> has not been initialized.");
            }

            return new DatatypeObject(new Null(), null);
        }
}
