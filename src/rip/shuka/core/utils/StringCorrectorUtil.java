package rip.shuka.core.utils;

public class StringCorrectorUtil {
    public static String correctForConsole(String str) {
        // Basic Escape Sequences & \s for spaces & \c for command
        str = str
                .replace("\\t", "\t")
                .replace("\\n", "\n")
                .replace("\\s", " ")
                .replace("\\c", ",");

        return str;
    }
}
