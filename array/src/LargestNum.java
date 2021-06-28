package array.src;

import java.util.Arrays;

/*
 * https://leetcode.com/submissions/detail/494855699/
 * */
public class LargestNum {
    /* T : O(nlogn)
        S : O(n)
    */
    public String largestNumber(int[] A) {
        int n = A.length;
        
        String[] sa = new String[n];
        for(int i = 0; i < n; i++){
            sa[i] = Integer.toString(A[i]);
        }
        
        Arrays.sort(sa, (s1, s2) -> (s2 + s1).compareTo(s1 + "" + s2));
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++){
            res.append(sa[i]);
        }
        
        if(res.length() > 1 && res.charAt(0) == '0'){   // got something like "00...0"
            return "0";
        }
        return res.toString();
    }
}