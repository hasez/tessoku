package graph;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import common.AbstractTest;
import common.FileScanner;

public class A64Test extends AbstractTest {
    @Test
    public void testMain_1() {
        String input = """
                6 7
                1 2 15
                1 4 20
                2 3 65
                2 5 4
                3 6 50
                4 5 30
                5 6 8
                """;
        String expected = """
                0
                15
                77
                20
                19
                27
                """;
        in.append(input);
        A64.main(null);
        String actual = out.getOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testMain_2() {
        String input = """
                15 30
                10 11 23
                11 13 24
                5 8 22
                10 15 18
                12 14 15
                2 10 11
                4 7 15
                5 7 15
                7 9 8
                8 12 1
                5 14 1
                10 14 17
                10 12 11
                8 10 6
                7 14 28
                6 9 1
                1 10 19
                4 5 4
                9 10 21
                7 10 21
                4 10 29
                5 10 8
                4 14 8
                11 12 24
                10 13 13
                3 10 1
                5 12 24
                2 15 23
                6 10 18
                6 15 25
                """;
        String expected = """
                0
                30
                20
                31
                27
                37
                40
                25
                38
                19
                42
                26
                32
                28
                37
                """;
        in.append(input);
        A64.main(null);
        String actual = out.getOutput();
        assertEquals(expected, actual);
    }
    @Test
    public void testMain_04() throws IOException {
        String input = readFile("A64/in/04.txt");
        String expected = readFile("A64/out/04.txt");
        in.append(input);
        A64.main(null);
        String actual = out.getOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testMain_do_not_move() {
        String input = """
                3 1
                2 3 1
                """;
        String expected = """
                0
                -1
                -1
                """;
        in.append(input);
        A64.main(null);
        String actual = out.getOutput();
        assertEquals(expected, actual);
    }

}
