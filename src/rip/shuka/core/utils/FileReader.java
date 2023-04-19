package rip.shuka.core.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public void read(String fileName) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println);
        } catch (NoSuchFileException e) {
            System.err.println("Keine Datei in dem Pfad gefunden.");
        }
    }
}
