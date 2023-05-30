package rip.shuka.core.logic.functions;

import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.parameter.Parameter;

public class RuntimeFunction extends Function {
    private String[] lines;

    public RuntimeFunction(String name, Parameter[] parameters) {
        super(name, parameters);
        this.lines = new String[0];
    }

    public String[] getLines() {
        return lines;
    }

    public void setLines(String[] lines) {
        this.lines = lines;
    }

    public void addLine(String line) {
        String[] newLines = new String[lines.length + 1];
        for (int i = 0; i < lines.length; i++) {
            newLines[i] = lines[i];
        }
        newLines[lines.length] = line;
        lines = newLines;
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        return null;
    }
}
