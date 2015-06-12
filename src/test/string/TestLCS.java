package test.string;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import string.LCS;

public class TestLCS {
    private LCS lcs;

    @Before public void init() {
        lcs = new LCS("abcdecdecd", "cdec");
    }

    @Test public void func() {
        Assert.assertEquals(4, lcs.func());
    }

    @After public void destory() {
        lcs = null;
    }
}
