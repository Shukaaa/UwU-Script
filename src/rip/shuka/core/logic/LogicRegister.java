package rip.shuka.core.logic;

import rip.shuka.core.logic.base.BaseElement;
import rip.shuka.core.logic.base.elements.Comments;
import rip.shuka.core.logic.functions.Arrays.FH.ArrayFH;
import rip.shuka.core.logic.functions.Cast.FH.CastFH;
import rip.shuka.core.logic.functions.Console.FH.ConsoleFH;
import rip.shuka.core.logic.functions.ControlStructures.FH.ControlStructuresFH;
import rip.shuka.core.logic.functions.Func.FH.FuncFH;
import rip.shuka.core.logic.functions.FunctionHolder;
import rip.shuka.core.logic.functions.Incrementer.FH.IncrementerFH;
import rip.shuka.core.logic.functions.Logic.FH.LogicFH;
import rip.shuka.core.logic.functions.Loop.FH.LoopFH;
import rip.shuka.core.logic.functions.Math.FH.MathFH;
import rip.shuka.core.logic.functions.System.FH.SystemFH;
import rip.shuka.core.logic.functions.Variables.FH.VariablesFH;

public class LogicRegister {
    public static final BaseElement comments = new Comments();

    public static final FunctionHolder[] functionHolder = {
            new ConsoleFH(),
            new SystemFH(),
            new VariablesFH(),
            new MathFH(),
            new LogicFH(),
            new CastFH(),
            new ArrayFH(),
            new IncrementerFH()
    };

    public static final FunctionHolder csFH = new ControlStructuresFH();
    public static final FunctionHolder funcFH = new FuncFH();
    public static final FunctionHolder loopFH = new LoopFH();
}
