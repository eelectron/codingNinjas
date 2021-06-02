package numerical;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/*
 * Reference : https://leetcode.com/problems/power-of-three/
 * Check leetcode for more approaches
 * */
public class PowerOfTen {
    /*
     * T : O(logn) 
     * S : O(logn)
     * logn is number of digits in integer n
     * Idea : Any number which is a power of 10 will always looks 
     * like starting with 1 followed by zero or more 0 . 
     * */
    /*
    public boolean isPowerOfTen(long n) {
        String s = Long.toString(n);
        boolean found = s.matches("^10*$");
        return found;
    }
    */
    
    
    /*
     * T : O(logn) , depends on implementation of Math.log10
     * S : O(1)
     * Idea : If number n is power of 10 , then exp = Math.log10(n) is ALWAYS integer
     * otherwise it will have fractional part .
     * */
    public boolean isPowerOfTen(long n) {
        double exp = Math.log10(n);
        if(exp == (int)exp) {
            return true;
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        
    }
    
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
