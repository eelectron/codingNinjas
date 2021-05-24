package demo;

// stair case
// n steps
/*
 * constraint
 * - 1 step
 * - 2 step
 * ways to reach nth step
 * 
 * n = 1
 * out = 1
 * 
 * n = 2
 * 1 1
 * 2
 * out  = 2
 * ways(n) = ways(n - 1) + ways(n - 2)
 * base case : 0
 * 
 * n = 3
 * 
 * 1 1 1
 * 1 2
 * 2 1
 * 
 * 
 
 * */
public class Practice {
    
    public int waysToClimb(int n) {
        if(n < 2) {
            return 1;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
