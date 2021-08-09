package source.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * https://leetcode.com/submissions/detail/492263774/
 * 
 * The approach for this question 
 * https://sites.google.com/view/leetcodepractice/firstuniquechar
 * */

public class FirstUniqueChar {
    public int firstUniqChar(String s) {
    	if(s == null) {
    		return -1;
    	}
    	
        int n = s.length();
        Map<Character, Integer> map = new LinkedHashMap<>();
        
        char ch;
        for(int i = 0; i < n; i++){
            ch = s.charAt(i);
            if(map.containsKey(ch)) {
            	map.put(ch, -1);
            }
            else {
            	map.put(ch, i);
            }
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
        	if(entry.getValue() != -1) {
        		return entry.getValue();
        	}
        }
        return -1;
    }
}