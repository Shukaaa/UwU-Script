package rip.shuka.core.syntax;

public class SyntaxDatatype<ReferenceDatatype> {
    private final String name;
    private final Class<ReferenceDatatype> type;

    public SyntaxDatatype(String name, Class<ReferenceDatatype> type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Class<ReferenceDatatype> getType() {
        return type;
    }
}
