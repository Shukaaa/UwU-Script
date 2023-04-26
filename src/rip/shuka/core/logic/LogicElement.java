package rip.shuka.core.logic;

import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.parameter.Parameter;

public abstract class LogicElement {
    private final String name;
    private final Parameter[] parameters;

    protected LogicElement(String name, Parameter[] parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public abstract DatatypeObject execute(DatatypeObject[] args);

    public String getName() {
        return name;
    }

    public Parameter[] getParameters() {
        return parameters;
    }
}
