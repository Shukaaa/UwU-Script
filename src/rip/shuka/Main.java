package rip.shuka;

import rip.shuka.core.utils.ErrorUtil;
import rip.shuka.core.utils.FileReaderUtil;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {


        if (args.length >= 1) {
            String file = null;
            boolean speed_test = false;

            Pattern pattern = Pattern.compile("=([^=]*)$");

            for (String arg : args) {
                Matcher matcher = pattern.matcher(arg);

                if (arg.startsWith("file") && matcher.find()) {
                    file = matcher.group(1);
                }

                if (arg.startsWith("speed_test") && matcher.find()) {
                    speed_test = Boolean.parseBoolean(matcher.group(1));
                }
            }

            if (file == null) { ErrorUtil.callError("Kein Pfad wurde ausgewählt"); }

            assert file != null;
            if (!file.endsWith(".uwu")) {
                file = file + ".uwu";
            }

            if (speed_test) {
                long startTime = System.nanoTime();

                read(file);

                long endTime = System.nanoTime();

                long executionTime = endTime - startTime;
                double seconds = (double) executionTime / 1_000_000_000.0;

                System.out.println("Execution time: " + seconds + " seconds");
                return;
            }

            read(file);
        } else {
            ErrorUtil.callError("Kein Pfad wurde ausgewählt");
        }
    }

    private static void read(String file) throws IOException {
        FileReaderUtil fileReader = new FileReaderUtil();

        fileReader.read(file);
    }
}
