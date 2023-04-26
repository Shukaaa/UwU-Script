package rip.shuka.core.corrector;

public class StringCorrector {
    public static String correctForConsole(String str) {
        // Basic Escape Sequences & \s for spaces
        str = str.replace("\\t", "\t").replace("\\n", "\n").replace("\\s", " ");

        return str;
    }
}
