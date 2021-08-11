package source.array;

/*
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * */
public class MinSizeSubarray {
	 public int minSubArrayLen(int target, int[] A) {
		int n = A.length;
        int res = n + 1;
        long bag = 0;
        
        int j = 0;
        for(int i = 0; i < n; i++){
            while(j < n && bag < target){
                bag += A[j];
                j += 1;
            }
            
            if(bag >= target){
                res = Math.min(res, j - i);
            }
            
            bag -= A[i];
        }
        
        if(res == n + 1){
            return 0;
        }
        return res;
	 }
}