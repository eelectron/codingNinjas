package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/submissions/detail/502769394/
 * Idea : merge sorted list 
 * */
class WordDistance {
    Map<String, List<Integer>> wordIndex;
    public WordDistance(String[] wordsDict) {
        wordIndex = new HashMap<>();
        int n = wordsDict.length;
        
        String cs = "";
        for(int i = 0; i < n; i++){
            cs = wordsDict[i];
            List<Integer> inList = wordIndex.get(cs);
            if(inList == null){
                inList = new ArrayList<>();
                wordIndex.put(cs, inList);
            }
            
            inList.add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int minDis = Integer.MAX_VALUE;
        
        List<Integer> ind1 = wordIndex.get(word1);
        List<Integer> ind2 = wordIndex.get(word2);
        
        int i = 0, j = 0;
        int in1, in2;
        while(i < ind1.size() && j < ind2.size()){
            in1 = ind1.get(i);
            in2 = ind2.get(j);
            minDis = Math.min(minDis, Math.abs(in1 - in2));
            
            if(in1 < in2){
                i += 1;
            }
            else{
                j += 1;
            }
        }
        return minDis;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */