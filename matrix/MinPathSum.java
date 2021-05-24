package matrix;

import java.util.Arrays;
/*
 * https://leetcode.com/submissions/detail/497517393/
 * T : O(no. of cells in matrix = m * n)
 * S : O(no. of cells in one row = n)
 * 
 * Idea : minCost[i][j] = cost(i, j) + min(minCost[i - 1][j], minCost[i][j - 1])
 * */
public class MinPathSum {
    public int minPathSum(int[][] G) {
        if(G == null){
            return -1;
        }
        
        int m = G.length;
        int n = G[0].length;
        
        int[][] dp = new int[2][n];
        dp[0] = Arrays.copyOf(G[0], n);
        for(int j = 1; j < n; j++){
            dp[0][j] += dp[0][j - 1]; 
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    dp[1][j] = dp[0][j] + G[i][j];
                }
                else{
                    dp[1][j] = G[i][j] + Math.min(dp[0][j], dp[1][j - 1]);
                }
            }
            dp[0] = Arrays.copyOf(dp[1], n);
            Arrays.fill(dp[1], 0);
        }
        return dp[0][n - 1];
    }
}