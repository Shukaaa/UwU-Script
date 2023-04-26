package rip.shuka.core.logic.datatypes;

import rip.shuka.core.logic.datatypes.types.Any;

public record DatatypeObject(Datatype datatype, java.lang.String value) {
    public boolean isValidDatatype(Datatype datatype) {
        return datatype().getName().equals(datatype.getName()) || datatype.getName().equals(new Any().getName());
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
