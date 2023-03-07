package data.structure;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import common.AbstractTest;

public class A51Test extends AbstractTest {
    @Test
    public void testMain() {
        String input = """
                5
                1 futuremap
                1 howtospeak
                2
                3
                2
                """;
        String expected = """
                howtospeak
                futuremap
                """;
        in.append(input);
        A51.main(null);
        String actual = out.getOutput();
        assertEquals(expected, actual);
    }
}
