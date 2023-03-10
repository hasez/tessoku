package graph;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import common.AbstractTest;

public class B63Test extends AbstractTest {
    @Test
    public void testMain_1() {
        String input = """
                7 8
                2 2
                4 5
                ########
                #......#
                #.######
                #..#...#
                #..##..#
                ##.....#
                ########
                """;
        String expected = """
                11
                """;
        in.append(input);
        B63.main(null);
        String actual = out.getOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testMain_2() {
        String input = """
                5 8
                2 2
                2 4
                ########
                #.#....#
                #.###..#
                #......#
                ########
                """;
        String expected = """
                10
                """;
        in.append(input);
        B63.main(null);
        String actual = out.getOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testMain_3() {
        String input = """
                50 50
                2 2
                49 49
                ##################################################
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                #................................................#
                ##################################################
                """;
        String expected = """
                94
                """;
        in.append(input);
        B63.main(null);
        String actual = out.getOutput();
        assertEquals(expected, actual);
    }

}
