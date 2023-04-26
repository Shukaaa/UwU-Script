package rip.shuka;

import rip.shuka.core.utils.ErrorUtil;
import rip.shuka.core.utils.FileReaderUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReaderUtil fileReader = new FileReaderUtil();

        if (args.length == 1) {
            String file = args[0];

            if (!file.endsWith(".uwu")) {
                file = file + ".uwu";
            }

            fileReader.read(file);
        } else {
            ErrorUtil.callError("Kein Pfad wurde ausgewählt");
        }

    }
}
