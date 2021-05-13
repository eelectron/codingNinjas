package string;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/submissions/detail/492263774/
 * 
 * The approach for this question 
 * https://sites.google.com/view/leetcodepractice/firstuniquechar
 * */

public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        
        char ch;
        for(int i = 0; i < n; i++){
            ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(int i = 0; i < n; i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}