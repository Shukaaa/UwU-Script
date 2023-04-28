package rip.shuka.core.logic.variables;

public class VariableStore {
    private final static VariableStore instance = new VariableStore();
    private Variable[] variables;

    private VariableStore() {
        variables = new Variable[0];
    }

    public static VariableStore getInstance() {
        return instance;
    }

    public void addVariable(Variable variable) {
        // Replace variable if it already exists
        for (int i = 0; i < variables.length; i++) {
            if (variables[i].name().equals(variable.name())) {
                variables[i] = variable;
                return;
            }
        }

        // Add variable if it doesn't exist
        Variable[] newVariables = new Variable[variables.length + 1];
        System.arraycopy(variables, 0, newVariables, 0, variables.length);
        newVariables[newVariables.length - 1] = variable;
        variables = newVariables;
    }

    public Variable getVariable(String name) {
        for (Variable variable : variables) {
            if (variable.name().equals(name)) {
                return variable;
            }
        }
        return null;
    }
}
