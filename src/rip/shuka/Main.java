package rip.shuka;

import rip.shuka.core.error.CallError;
import rip.shuka.core.utils.FileReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        FileReader fileReader = new FileReader();

        System.out.println("End main thread.");

        if (args.length == 1) {
            String file = args[0];

            if (!file.endsWith(".uwu")) {
                file = file + ".uwu";
            }

            fileReader.read(file);
        } else {
            CallError.callError("Kein Pfad wurde ausgewählt");
        }

    }
}
