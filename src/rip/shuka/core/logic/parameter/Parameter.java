package rip.shuka.core.logic.parameter;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;

public class Parameter {
    // If a value is set, it is an optional parameter, if it shouldn't be an optional parameter always type null
    final DatatypeObject value;
    // No use case rn, but maybe later xd?
    final String description;
    final Datatype[] types;
    boolean infinityParam = false;

    public Parameter(DatatypeObject value, Datatype[] types, String description) {
        this.value = value;
        this.types = types;
        this.description = description;
    }

    public void beInfinityParam() {
        infinityParam = true;
    }

    public boolean isInifinity() {
        return infinityParam;
    }

    public DatatypeObject getValue() {
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
