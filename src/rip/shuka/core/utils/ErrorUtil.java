package rip.shuka.core.utils;

public class ErrorUtil {
    public static void callError(String error) {
        System.err.println(error);
        System.exit(1);
    }
}
