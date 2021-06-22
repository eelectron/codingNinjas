package numerical.src;

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
}
