package rip.shuka.core.logic.functions;

public class RuntimeFunctionStore {
    private static RuntimeFunction[] functions = new RuntimeFunction[0];

    public static void addFunction(RuntimeFunction function) {
        RuntimeFunction[] newFunctions = new RuntimeFunction[functions.length + 1];
        for (int i = 0; i < functions.length; i++) {
            newFunctions[i] = functions[i];
        }
        newFunctions[functions.length] = function;
        functions = newFunctions;
    }

    public static RuntimeFunction[] getFunctions() {
        return functions;
    }

    public static RuntimeFunction getFunction(String name) {
        for (RuntimeFunction function : functions) {
            if (function.getName().equals(name)) {
                return function;
            }
        }
        return null;
    }
}
