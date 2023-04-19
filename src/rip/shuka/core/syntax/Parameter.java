package rip.shuka.core.syntax;

public class Parameter {
    String value;
    String description;
    SyntaxDatatype[] types;

    public Parameter(String value, SyntaxDatatype[] types, String description) {
        this.value = value;
        this.types = types;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public SyntaxDatatype[] getTypes() {
        return types;
    }

    public String getDescription() {
        return description;
    }
}
