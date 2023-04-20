package rip.shuka.core.syntax;

public class Datatype {
    private final String name;
    private final Class<?> type;

    public Datatype(String name, Class<?> type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Class<?> getType() {
        return type;
    }
}
