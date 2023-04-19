package rip.shuka;

import rip.shuka.core.utils.FileReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();

        if (args.length == 1) {
            String file = args[0];

            if (!file.endsWith(".uwu")) {
                System.err.println("Keine Datei mit der .uwu-Endung gefunden");
                return;
            }

            fileReader.read(file);
        } else {
            System.err.println("Kein Pfad wurde ausgewählt");
        }

    }
}
