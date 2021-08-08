package source.array;

/*
 * Prerequisite : please understand this problem (Largest Histogram) https://leetcode.com/submissions/detail/492954779/
 * before doing this problem
 * 
 * Solution : https://leetcode.com/submissions/detail/493341015/
 * T : O(m * n)
 * S : O(n)
 * */
public class MaximalRectangle {
    public int maximalRectangle(char[][] M) {
        if(M == null || M.length == 0){
            return 0;
        }
        
        int rows = M.length;
        int cols = M[0].length;
        
        int[] base = new int[cols];
        int maxArea = 0, curArea = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(M[i][j] == '1'){
                    base[j] += 1;
                }
                else{
                    base[j] = 0;
                }
            }
            
            curArea = largestRectangleArea(base);
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
    
    private int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        
        int n = heights.length;
        if(n == 1){
            return heights[0];
        }
        
        // find index of first bar in left side whose height is less than current bar
        int[] leftMinBar = new int[n];
        leftMinBar[0] = -1;
        for(int i = 1; i < n; i++){
            int k = i - 1;
            while(k >= 0 && heights[k] >= heights[i]){
                k = leftMinBar[k];
            }
            leftMinBar[i] = k;
        }
        
        // find index of first bar in right side whose height is less than current bar
        int[] rightMinBar = new int[n];
        rightMinBar[n - 1] = n;
        for(int i = n - 2; i >= 0; i--){
            int k = i + 1;
            while(k < n && heights[k] >= heights[i]){
                k = rightMinBar[k];
            }
            rightMinBar[i] = k;
        }
        
        // consider largest rectangle formed by each bar
        int maxArea = 0, curArea = 0;
        for(int i = 0; i < n; i++){
            curArea = heights[i] * (rightMinBar[i] - leftMinBar[i] - 1);
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;
    }
}