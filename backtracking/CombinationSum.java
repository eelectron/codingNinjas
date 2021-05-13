package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/submissions/detail/492557098/
 * */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] cand, int target) {
        if(cand == null || cand.length == 0){
            return null;
        }
        
        int start = 0;
        List<List<Integer>> res = getComb(cand, start, target);
        return res;
    }
    
    private List<List<Integer>> getComb(int[] cand, int start, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(target == 0){
            res.add(new ArrayList<>());
            return res;
        }
        
        if(target < 0){
            return res;
        }
        
        if(start >= cand.length){
            return res;
        }
        
        // get all combination without cand[start]
        List<List<Integer>> exc = getComb(cand, start + 1, target);
        res.addAll(exc);
        
        // get all combination which contains cand[start]
        List<List<Integer>> inc = getComb(cand, start, target - cand[start]);
        for(int i = 0; i < inc.size(); i++){
            inc.get(i).add(cand[start]);
            res.add(inc.get(i));
        }
        return res;
    }
}