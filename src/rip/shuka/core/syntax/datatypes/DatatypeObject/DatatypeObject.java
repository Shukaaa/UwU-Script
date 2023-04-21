package rip.shuka.core.syntax.datatypes.DatatypeObject;

import rip.shuka.core.syntax.Datatype;
import rip.shuka.core.syntax.datatypes.Any;

public record DatatypeObject(Datatype datatype, String value) {
    public boolean isValidDatatype(Datatype datatype) {
        return datatype().getName().equals(datatype.getName())
                || datatype.getName().equals(new Any().getName());
    }

    public boolean isValidDatatype(Datatype[] datatypes) {
        for (Datatype datatype : datatypes) {
            if (isValidDatatype(datatype)) {
                return true;
            }
        }

        return false;
    }
}
