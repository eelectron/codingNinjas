package array.src;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/submissions/detail/494788357/
 * T : O(n)
 * O : O(n)
 * */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] A) {
        if(A == null || A.length <= 1){
            return false;
        }
        
        int n = A.length;
        Boolean[] memo = new Boolean[n];
        Map<Integer, Integer> seen = new HashMap<>();    // keep all index seen so far
        boolean sign = true;
        for(int i = 0; i < n; i++){
            sign = true;
            if(A[i] < 0){       // the cycle elements should have same sign
                sign = false;
            }
            
            seen = new HashMap<>();
            if(hasCycle(A, i, sign, memo, seen) == true){
                return true;
            }
        }
        return false;
    }
    
    private boolean hasCycle(int[] A, int startId, boolean sign, Boolean[] memo, Map<Integer, Integer> seen){
        if(seen.containsKey(startId) == true){
            int itemsOfCycle = seen.size() - seen.get(startId);
            if(itemsOfCycle <= 1){
                return false;       // cycle has only 1 item
            }
            return true;            // cycle has more than one item
        }
        
        if(sign == true && A[startId] < 0){     // sign(A[src]) != sign(A[startId])
            return false;
        }
        
        if(sign == false && A[startId] > 0){    // sign(A[src]) != sign(A[startId])
            return false;
        }
        
        if(memo[startId] != null){              // already know the answer
            return memo[startId];
        }
        
        seen.put(startId, seen.size());
        
        int n = A.length;
        int nextId = (n + startId + A[startId] % n) % n;    // next id
        memo[startId] = hasCycle(A, nextId, sign, memo, seen);
        return memo[startId];
    }
}