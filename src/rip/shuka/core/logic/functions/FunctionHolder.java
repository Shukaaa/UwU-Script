package rip.shuka.core.logic.functions;

public class FunctionHolder {
    private final String name;
    private final Function[] functions;

    public FunctionHolder(String name, Function[] functions) {
        this.name = name;
        this.functions = functions;
    }

    public String getName() {
        return name;
    }

    public Function[] getFunctions() {
        return functions;
    }
}
