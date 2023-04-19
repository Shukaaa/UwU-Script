package rip.shuka.core.utils;

import rip.shuka.core.error.CallError;
import rip.shuka.core.interpreter.Interpreter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    Interpreter INTERPRETER = new Interpreter();

    public void read(String fileName) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            // Stream to Array
            String[] lines = stream.toArray(String[]::new);

            for (int i = 0; i < lines.length; i++) {
                INTERPRETER.interpretLine(lines[i], i+1);
            }
        } catch (NoSuchFileException e) {
            CallError.callError("Die Datei <" + fileName + "> wurde in dem Pfad nicht gefunden.");
        }
    }
}
