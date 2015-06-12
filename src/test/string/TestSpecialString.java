package test.string;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import string.SpecialString;

public class TestSpecialString{
    private SpecialString specialString;

    @Before public void init() {
        specialString = new SpecialString();
    }

    @Test public void isPalindromes() throws Exception {
        Assert.assertEquals(true, specialString.isPalindromes("abcba"));
    }

    @After public void destory() {
        specialString = null;
    }


}
