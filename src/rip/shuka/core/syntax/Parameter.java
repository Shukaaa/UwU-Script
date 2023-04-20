package rip.shuka.core.syntax;

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
}
