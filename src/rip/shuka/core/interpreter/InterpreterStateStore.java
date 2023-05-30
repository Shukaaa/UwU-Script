package rip.shuka.core.interpreter;

public class InterpreterStateStore {
    public static boolean if_result = true;
    public static boolean else_flag = false;
    public static boolean function_flag = false;

    public static String latest_runtime_function_name = "";
}
