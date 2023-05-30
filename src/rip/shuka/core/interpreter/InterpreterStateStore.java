package rip.shuka.core.interpreter;

import java.util.ArrayList;

public class InterpreterStateStore {
    public static boolean if_result = true;
    public static boolean else_flag = false;
    public static boolean function_flag = false;

    public static String latest_runtime_function_name = "";

    public static ArrayList<LoopInformation> loop_information = new ArrayList<>();
    public static boolean loopBreaked = false;
}
