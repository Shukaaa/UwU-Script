package rip.shuka.core.logic;

import rip.shuka.core.logic.base.BaseElement;
import rip.shuka.core.logic.datatypes.*;
import rip.shuka.core.logic.datatypes.types.*;
import rip.shuka.core.logic.datatypes.types.Boolean;
import rip.shuka.core.logic.datatypes.types.Float;
import rip.shuka.core.logic.datatypes.types.Integer;
import rip.shuka.core.logic.datatypes.types.String;
import rip.shuka.core.logic.base.elements.Comments;
import rip.shuka.core.logic.functions.Console.FH.ConsoleFH;
import rip.shuka.core.logic.functions.FunctionHolder;
import rip.shuka.core.logic.functions.Logic.FH.LogicFH;
import rip.shuka.core.logic.functions.Math.FH.MathFH;
import rip.shuka.core.logic.functions.System.FH.SystemFH;
import rip.shuka.core.logic.functions.Variables.FH.VariablesFH;

public class LogicRegister {
    public static BaseElement comments = new Comments();

    public static FunctionHolder[] functionHolder = {
            new ConsoleFH(),
            new SystemFH(),
            new VariablesFH(),
            new MathFH(),
            new LogicFH()
    };

    public static Datatype[] datatypes = {
            new Integer(),
            new String(),
            new Float(),
            new Any(),
            new Boolean(),
            new Null()
    };
}
