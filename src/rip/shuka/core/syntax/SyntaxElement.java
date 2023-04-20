package rip.shuka.core.syntax;

import rip.shuka.core.syntax.datatypes.DatatypeObject.DatatypeObject;

public abstract class SyntaxElement {
    private final String name;
    private final SyntaxTypes type;
    private final Parameter[] parameters;

    protected SyntaxElement(String name, SyntaxTypes type, Parameter[] parameters) {
        this.name = name;
        this.type = type;
        this.parameters = parameters;
    }

    public abstract DatatypeObject execute(DatatypeObject[] args);

    public String getName() {
        return name;
    }

    public SyntaxTypes getType() {
        return type;
    }

    public Parameter[] getParameters() {
        return parameters;
    }
}
