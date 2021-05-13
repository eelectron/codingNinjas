package array;
/*
 * 
 * https://leetcode.com/submissions/detail/492623779/
 * */

public class TrappingRainWater {
    /*
    T : O(n)
    S : O(n)
    */
    public int trap(int[] height) {
        if(height == null || height.length <= 1){
            return 0;
        }
        
        // key point : After rain, we can find the amount of water each bar can hold
        // The amount of water that each bar can hold is ONLY decided by max bar present towards it's left and max bar towards its right 
        
        int n = height.length;
        
        // find max bar towards left for each bar
        int[] maxLeft = new int[n];
        maxLeft[0] = height[0];
        for(int i = 1; i < n; i++){
            maxLeft[i] = height[i];
            if(maxLeft[i - 1] > height[i]){
                maxLeft[i] = maxLeft[i - 1];
            }
        }
        
        // find max bar towards right for each bar
        int[] maxRight = new int[n];
        maxRight[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            maxRight[i] = height[i];
            if(maxRight[i + 1] > height[i]){
                maxRight[i] = maxRight[i + 1];
            }
        }
        
        // find total rain water
        int totalWater = 0, water = 0;
        for(int i = 1; i < n - 1; i++){
            water = (Math.min(maxLeft[i], maxRight[i])) - height[i];
            if(water > 0){
                totalWater += water;
            }
        }
        return totalWater;
    }
}