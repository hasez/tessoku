package common;

import org.junit.After;
import org.junit.Before;

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
}
