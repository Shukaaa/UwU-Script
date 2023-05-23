package rip.shuka.core.utils;

import rip.shuka.core.interpreter.Interpreter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderUtil {
    public void read(String fileName) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            // Stream to Array
            String[] lines = stream.toArray(String[]::new);

            for (int i = 0; i < lines.length; i++) {
                int finalI = i;
                Thread thread = new Thread(() -> Interpreter.interpretLine(lines[finalI], finalI + 1));

                thread.start();
                thread.join();
            }
        } catch (NoSuchFileException e) {
            ErrorUtil.callError("Die Datei <" + fileName + "> wurde in dem Pfad nicht gefunden.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
