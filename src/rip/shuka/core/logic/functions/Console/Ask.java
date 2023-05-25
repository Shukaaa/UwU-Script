package rip.shuka.core.logic.functions.Console;

import rip.shuka.core.logic.datatypes.Datatype;
import rip.shuka.core.logic.datatypes.DatatypeObject;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.functions.Function;
import rip.shuka.core.logic.parameter.Parameter;
import rip.shuka.core.utils.ErrorUtil;
import rip.shuka.core.utils.StringCorrectorUtil;

import java.util.Scanner;

public class Ask extends Function {
    public Ask() {
        super("ask", new Parameter[] {
                new Parameter(new DatatypeObject(new String(), ""), new Datatype[] { new String()}, "The text to ask")
        });
    }

    @Override
    public DatatypeObject execute(DatatypeObject[] args) {
        Scanner scanner = new Scanner(System.in);
        DatatypeObject result = null;

        if (scanner.hasNextLine()) {
            System.out.println(StringCorrectorUtil.correctForConsole(args[0].value()));
            result = new DatatypeObject(new String(), scanner.nextLine());
        } else {
            ErrorUtil.callError("No line found.");
        }

        scanner.close();

        return result;
    }
}
