package test.tree;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import tree.BinaryTree;

/**
 * BinaryTree Tester.
 *
 * @author <Authors name>
 * @since <pre>Ê®ÔÂ 17, 2014</pre>
 * @version 1.0
 */
public class TestBinaryTree {

    private BinaryTree<Character> binaryTree;

    @Before
    public void before() throws Exception {
        binaryTree = new BinaryTree<Character>();
        binaryTree = binaryTree.string2Tree("a(b(d,),c(f,g))");
    }

    @After
    public void after() throws Exception {
        binaryTree = null;
    }

    /**
     *
     * Method: findNode(BinaryTree<T> btree, T value)
     *
     */
    @Test
    public void testFindNode() throws Exception {
        Assert.assertEquals(true, binaryTree.findNode(binaryTree, 'a'));
    }

    /**
     *
     * Method: string2Tree(String string)
     *
     */
    @Test
    public void testString2Tree() throws Exception {
//TODO: Test goes here... 
    }

    /**
     *
     * Method: toString()
     *
     */
    @Test
    public void testToString() throws Exception {
//TODO: Test goes here... 
    }

    /**
     *
     * Method: main(String[] args)
     *
     */
    @Test
    public void testMain() throws Exception {
//TODO: Test goes here... 
    }


    /**
     *
     * Method: display(BinaryTree<T> bt)
     *
     */
    @Test
    public void testDisplay() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = BinaryTree.getClass().getMethod("display", BinaryTree<T>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
