package rip.shuka.core.error;

public class CallError {
    public static void callError(String error) {
        System.err.println(error);
        System.exit(1);
    }
}
