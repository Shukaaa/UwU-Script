package rip.shuka.core.logic.parameter;

import rip.shuka.core.logic.datatypes.Datatype;

public class Parameter {
    String value;
    String description;
    Datatype[] types;

    public Parameter(String value, Datatype[] types, String description) {
        this.value = value;
        this.types = types;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public Datatype[] getTypes() {
        return types;
    }

    public String getDescription() {
        return description;
    }

    public boolean isRequired() { return value == null; }
}
