package test.floyd;

import floyd.Floyd;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Floyd Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®ÔÂ 27, 2014</pre>
 */
public class FloydTest {
    public static final int MAX = 9999999;
    private Floyd floyd;

    @Before
    public void before() throws Exception {
        int[][] matrix = {{0, MAX, 3, MAX},
                {2, 0, MAX, MAX},
                {MAX, 7, 0, 1},
                {6, MAX, MAX, 0}};
        floyd = new Floyd(matrix);
        floyd.calMinPath();
    }

    @After
    public void after() throws Exception {
        floyd = null;
    }


    /**
     * Method: displayPath()
     */
    @Test
    public void testDisplayPath() throws Exception {
        floyd.displayPath();
    }

    @Test
    public void testShortestPath() throws Exception {
        floyd.shortestPath(1, 3);
    }


} 
