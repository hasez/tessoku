package common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

public class FileScannerTest {
    @Test
    public void testReadFileAll() {
        String expected = """
                1
                2
                """;
        try {
            Path tmpFile = Files.createTempFile("readFileTest", ".txt");
            Files.writeString(tmpFile, expected);
            FileScanner scanner = new FileScanner(tmpFile.toString());
            String actual = scanner.readFileAll();
            assertEquals(expected, actual);
        } catch (IOException ioe) {
            fail("raise Exception " + ioe.toString());
        }
    }

    @Test
    public void testReadFileAll_2() {
        try {
            FileScanner scanner = new FileScanner("resources/A64/in/04.txt");
            String actual = scanner.readFileAll();
        } catch (IOException ioe) {
            fail("raise Exception " + ioe.toString());
        }
    }
}
