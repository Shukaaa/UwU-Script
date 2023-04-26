package rip.shuka.core.logic.functions;

import rip.shuka.core.logic.LogicElement;

public class FunctionHolder {
    private final String name;
    private final LogicElement[] functions;

    public FunctionHolder(String name, LogicElement[] functions) {
        this.name = name;
        this.functions = functions;
    }

    public String getName() {
        return name;
    }

    public LogicElement[] getFunctions() {
        return functions;
    }
}
