package rip.shuka.core.logic.functions.Arrays;

import rip.shuka.core.logic.arrays.ArrayStore;
import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.Any;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.datatypes.types.Null;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.utils.ErrorUtil;

public class Replace extends Function {
        public Replace() {
            super("replace", new Parameter[] {
                    new Parameter(null, new Datatype[] { new String() }, "name of array"),
                    new Parameter(null, new Datatype[] { new Any() }, "value to add to array"),
                    new Parameter(null, new Datatype[] { new Integer() }, "index to add value to")
            });
        }

        @Override
        public DatatypeObject execute(DatatypeObject[] args) {
            try {
                ArrayStore.getInstance().getArray(args[0].value()).datatypeObjects().set(java.lang.Integer.parseInt(args[2].value()), args[1]);
            } catch (IndexOutOfBoundsException e) {
                ErrorUtil.callError("Array <" + args[0].value() + "> out of bounce.");
            }
            catch (Error e) {
                ErrorUtil.callError("Array <" + args[0].value() + "> has not been initialized.");
            }

            return new DatatypeObject(new Null(), null);
        }
}
