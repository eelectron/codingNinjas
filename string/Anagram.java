package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/submissions/detail/496084594/
 * 
 * T : O(s.length())
 * S : O(1) because we can have atmost 26 unique letters
 * 
 * This solution uses Sliding Window technique .
 * The tricky part was to figure out when our window is valid
 * */
public class Anagram {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || p == null){
            return res;
        }
        
        int m = s.length();
        int n = p.length();
        
        // keep p in bag
        Map<Character, Integer> bag = new HashMap<>();
        char ch;
        for(int i = 0; i < n; i++){
            ch = p.charAt(i);
            bag.put(ch, bag.getOrDefault(ch, 0) + 1);
        }
        
        // keep window item
        Map<Character, Integer> window = new HashMap<>();
        int windowSize = 0;
        
        // try to find p at each index of s
        int i = 0, j = 0;
        while(i < m){
            
            // keep adding valid char in window
            while(j < m){
                if(bag.containsKey(s.charAt(j)) == false || (window.getOrDefault(s.charAt(j), 0) >= bag.getOrDefault(s.charAt(j), 0))){
                    break;
                }
                window.put(s.charAt(j), window.getOrDefault(s.charAt(j), 0) + 1);
                windowSize += 1;
                j += 1;
            }
            
            // crucial condition for valid window
            // if we remove windowSize == n check , then will get incorrect result !
            if(window.size() == bag.size() && windowSize == n){    // got one valid index
                res.add(i);
            }
            
            ch = s.charAt(i);
            if(window.containsKey(ch) == true){
                window.put(ch, window.getOrDefault(ch, 0) - 1);
                
                // remove char from window if its count is 0
                if(window.getOrDefault(ch, 0) <= 0){
                    window.remove(ch);
                }
                
                // reduce windowSize
                windowSize -= 1;
            }
            
            // look at next index
            i += 1;
            if(j < i){  // j can't be behind i
                j = i;
            }
        }
        return res;
    }
}