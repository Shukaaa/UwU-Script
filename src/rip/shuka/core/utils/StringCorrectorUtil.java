package rip.shuka.core.utils;

public class StringCorrectorUtil {
    public static String correctForConsole(String str) {
        // Basic Escape Sequences & \s for spaces
        str = str.replace("\\t", "\t").replace("\\n", "\n").replace("\\s", " ");

        return str;
    }
}