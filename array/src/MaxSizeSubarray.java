package array.src;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/submissions/detail/494008780/
 * T : O(n)
 * S : O(n) because hashmap can have atmost n prefixSum
 * 
 * maxSizeSub[i...j] = prefixSum[0...j] - k = prefixSum[0...i]
 * where sum(i...j) == k
 * */
public class MaxSizeSubarray {
    public int maxSubArrayLen(int[] A, int k) {
        int n = A.length;
        Map<Integer, Integer> seen = new HashMap<>();
        int prefixSum = 0;
        int maxSizeSub = 0, prev = 0, curLen = 0;
        for(int i = 0; i < n; i++){
            prefixSum += A[i];
            prev = prefixSum - k;
            
            if(prev == 0){
                curLen = i + 1;     //sum(0...i + 1) == k
            }
            else if(seen.containsKey(prev) == true){
                curLen = (i + 1) - (seen.get(prev) + 1);
            }
            
            if(seen.containsKey(prefixSum) == false){
                seen.put(prefixSum, i);     // keep the first seen index of prefix sum in hashmap to get the longest sum subarray
            }
            maxSizeSub = Math.max(maxSizeSub, curLen);
        }
        return maxSizeSub;
    }
}