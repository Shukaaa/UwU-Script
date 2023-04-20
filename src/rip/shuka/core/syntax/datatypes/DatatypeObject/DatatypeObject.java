package rip.shuka.core.syntax.datatypes.DatatypeObject;

import rip.shuka.core.syntax.Datatype;
import rip.shuka.core.syntax.datatypes.Any;

public record DatatypeObject(Datatype datatype, String value) {
    public boolean isValidDatatype(Datatype datatype) {
        return datatype().getName().equals(datatype.getName())
                || datatype().getName().equals(new Any().getName())
                || datatype.getName().equals(new Any().getName());
    }

    public boolean isValidDatatype(Datatype[] datatypes) {
        if (datatypes.length == 0) {
            return false;
        }

        for (Datatype datatype : datatypes) {
            if (isValidDatatype(datatype)) {
                return true;
            }
        }

        return false;
    }
}
