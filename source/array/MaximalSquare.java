package source.array;
/*
 * Prerequisite : largest histogram https://leetcode.com/submissions/detail/492954779/
 * 
 * Solution: https://leetcode.com/submissions/detail/493358005/
 * T : O(mn)
 * S : O(n)
 * */
public class MaximalSquare {
    public int maximalSquare(char[][] M) {
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
            
            curArea = largestSquareArea(base);
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
    
    public int largestSquareArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        
        int n = heights.length;
        
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
        int maxArea = 0, curArea = 0, minSide = 0;
        for(int i = 0; i < n; i++){
            minSide = Math.min(heights[i], (rightMinBar[i] - leftMinBar[i] - 1));
            curArea = minSide * minSide;
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;
    }
}