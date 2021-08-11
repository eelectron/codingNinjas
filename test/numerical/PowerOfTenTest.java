package test.numerical;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import source.numerical.PowerOfTen;

public class PowerOfTenTest {
    @Test
    public void testIsPowerOfTen() {
        PowerOfTen pt = new PowerOfTen();
        
        assertTrue("expected true for 1", pt.isPowerOfTen(1));
        assertTrue("expected true for 10", pt.isPowerOfTen(10));
        assertTrue("expected true for 100", pt.isPowerOfTen(100));
        assertTrue("expected true for 10000000000000", pt.isPowerOfTen(10000000000000L));
        
        assertFalse("expected false for 2", pt.isPowerOfTen(2));
        assertFalse("expected false for 3", pt.isPowerOfTen(3));
        assertFalse("expected false for 1001", pt.isPowerOfTen(1001));
    }
}
