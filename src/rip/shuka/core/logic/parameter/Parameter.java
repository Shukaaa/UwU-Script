package rip.shuka.core.logic.parameter;

import rip.shuka.core.logic.datatypes.Datatype;

public class Parameter {
    // If a value is set, it is an optional parameter, if it shouldn't be an optional parameter always type null
    String value;
    // No use case rn, but maybe later xd?
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
