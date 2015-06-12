package test.tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import tree.OptBST;

/**
 * OptBST Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®ÔÂ 28, 2014</pre>
 */
public class OptBSTTest {

    private OptBST optBST = null;

    @Before
    public void before() throws Exception {
        double[] weight = new double[]{0.1, 0.2, 0.4, 0.3};
        optBST = new OptBST(weight);
        optBST.calOptBST(0, 3);
    }

    @After
    public void after() throws Exception {
        optBST = null;
    }

    /**
     * Method: displayWeight()
     */
    @Test
    public void testDisplayWeight() throws Exception {
        optBST.displayWeight();
    }

    /**
     * Method: displayPath()
     */
    @Test
    public void testDisplayPath() throws Exception {
        optBST.displayPath();
    }


} 
