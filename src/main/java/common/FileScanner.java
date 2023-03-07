package common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileScanner {
    private String fileName = null;
    public FileScanner(String fileName) {
        this.fileName = fileName;
    }
    public String readFileAll() throws IOException {
        Path filePath = Paths.get(fileName);
        return new String(Files.readAllBytes(filePath));
    }
}
