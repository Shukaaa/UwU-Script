package rip.shuka.core.logic.datatypes;

public class Datatype {
    private final java.lang.String name;
    private final Class<?> type;

    public Datatype(java.lang.String name, Class<?> type) {
        this.name = name;
        this.type = type;
    }

    public java.lang.String getName() {
        return name;
    }

    public Class<?> getType() {
        return type;
    }
}
