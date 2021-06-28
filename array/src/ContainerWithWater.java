package array.src;
/*
 * https://leetcode.com/submissions/detail/492584401/
 * */
public class ContainerWithWater {
    /*
    T : O(n)
    S : O(1)
    */
    public int maxArea(int[] height) {
        if(height == null || height.length <= 1){
            return 0;
        }
        
        int n = height.length;
        int lo = 0, hi = n - 1;
        int maxWater = 0;
        
        // keep iterating until we have more than one vertical lines
        while(lo < hi){
            
            // is this max water
            maxWater = Math.max(maxWater, (hi - lo) * Math.min(height[lo], height[hi]));
            
            // always leave the smaller vertical line among height[lo], height[hi]
            // because by leaving bigger line we can't improve the max area
            if(height[lo] <= height[hi]){
                lo += 1;
            }
            else{
                hi -= 1;
            }
        }
        return maxWater;
    }
}