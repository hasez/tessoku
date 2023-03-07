package common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractTest {
    protected StandardInputSnatcher in = new StandardInputSnatcher();
    protected StandardOutputSnatcher out = new StandardOutputSnatcher();

    @Before
    public void before() {
        System.setIn(in);
        System.setOut(out);
    }

    @After
    public void after() {
        System.setIn(null);
        System.setOut(null);
    }

    private String getTestFilePath(String fileName) {
        return "resources/" + fileName;
    }

    public String readFile(String fileName) throws IOException {
        String inputFileName = getTestFilePath(fileName);
        FileScanner inputScanner = new FileScanner(inputFileName);
        return inputScanner.readFileAll();
    }


}
