package numerical;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/submissions/detail/493997679/
 * T : O(no. of digits after decimal)
 * S : O(no. of digits in integral + no. of digits in fractional part)
 * */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int n, int d) {
        long num = n, den = d;
        if(num == 0){
            return "0";
        }
        
        int sign = 1;
        if(num < 0){
            sign *= -1;
        }
        
        if(den < 0){
            sign *= -1;
        }
        
        num = Math.abs(num);
        den = Math.abs(den);
        
        long intg = num / den;
        long rem = num % den;
        String intgS = Long.toString(intg);
        
        
        long div = rem * 10, q = 0;
        StringBuilder frac = new StringBuilder();
        Map<Long, Integer> seenQ = new HashMap<>();
        while(rem != 0 && seenQ.containsKey(div) == false){
            q = div / den;
            rem = div % den;
            seenQ.put(div, frac.length());
            frac.append(q);
            div = rem * 10;
        }
        
        // put repeating decimal in bracket
        if(seenQ.containsKey(div) == true){
            frac.insert(seenQ.get(div), "(");
            frac.append(')');
        }
        
        String res = intgS;
        if(frac.length() > 0){
            res = intgS + "." + frac.toString();    // append fractional part
        }
        
        // is negative
        if(sign < 0){
            res = "-" + res;
        }
        return res;
    }
}