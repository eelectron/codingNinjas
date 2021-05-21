package string;

import java.util.Arrays;
/*
 * https://leetcode.com/submissions/detail/495863418/
 * 
 * T : O(nlogn)
 * S : O(n)
 * 
 * It can also be done in O(n) time by using HashMap
 * */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m != n){
            return false;
        }
        
        char[] sa = s.toCharArray();
        Arrays.sort(sa);
        
        char[] ta = t.toCharArray();
        Arrays.sort(ta);
        
        for(int i = 0; i < m; i++){
            if(sa[i] != ta[i]){
                return false;
            }
        }
        return true;
    }
}