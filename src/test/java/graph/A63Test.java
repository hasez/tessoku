package graph;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.StandardInputSnatcher;
import common.StandardOutputSnatcher;

public class A63Test {
    private StandardInputSnatcher in = new StandardInputSnatcher();
    private StandardOutputSnatcher out = new StandardOutputSnatcher();

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

    @Test
    public void testMain_1() {
        String input = """
                3 2
                1 3
                2 3
                """;
        String expected = """
                0
                2
                1
                """;
        in.append(input);
        A63.main(null);
        String actual = out.getOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testMain_2() {
        String input = """
                6 6
                1 4
                2 3
                3 4
                5 6
                1 2
                2 4
                """;
        String expected = """
                0
                1
                2
                1
                -1
                -1
                """;
        in.append(input);
        A63.main(null);
        String actual = out.getOutput();
        assertEquals(expected, actual);
    }

}
