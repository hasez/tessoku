package graph;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.StandardInputSnatcher;
import common.StandardOutputSnatcher;

public class B61Test {
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
    public void testMain() {
        String input = """
                5 4
                1 2
                2 3
                3 4
                3 5
                """;
        String expected = """
                3
                """;
        in.append(input);
        B61.main(null);
        String actual = out.getOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testMain2() {
        String input = """
                15 30
                6 9
                9 10
                2 9
                9 12
                2 14
                1 4
                4 6
                1 3
                4 14
                1 6
                9 11
                2 6
                3 9
                5 9
                4 9
                11 15
                1 13
                4 13
                8 9
                9 13
                5 15
                3 5
                8 10
                2 4
                9 14
                1 9
                2 8
                6 13
                7 9
                9 15
                """;
        String expected = """
                9
                """;
        in.append(input);
        B61.main(null);
        String actual = out.getOutput();
        assertEquals(expected, actual);
    }

}
