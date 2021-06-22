package string.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/submissions/detail/496112961/
 * 
 * T : O(no. of words * log(average word length))
 * S : O(no. of chars in all words) */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null){
            return res;
        }
        
        int n = strs.length;
        
        // Idea : if we sort each string in one group , they will all be equal
        
        Map<String, ArrayList> groups = new HashMap<>();
        String str, sortedStr;
        for(int i = 0; i < n; i++){
            str = strs[i];
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            sortedStr = new String(ca);
            
            ArrayList<String> list = groups.get(sortedStr);
            if(list == null){
                list = new ArrayList<>();
                groups.put(sortedStr, list);
            }
            list.add(str);
        }
        
        for(Map.Entry<String, ArrayList> entry: groups.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}