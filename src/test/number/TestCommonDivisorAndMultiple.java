package test.number;

import junit.framework.Assert;
import number.CommonDivisorAndMultiple;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCommonDivisorAndMultiple {
    private CommonDivisorAndMultiple commonDivisorAndMultiple;

    @Before public void init() {
        commonDivisorAndMultiple = new CommonDivisorAndMultiple();
    }

    @Test public void maxCommonDivisor() {
        Assert.assertEquals(5, commonDivisorAndMultiple.maxCommonDivisor(10, 15));
    }

    @Test public void minCommonMultiple() {
        Assert.assertEquals(30, commonDivisorAndMultiple.minCommonMultiple(10, 15));
    }

    @After public void destory() {
        commonDivisorAndMultiple = null;
    }
}
