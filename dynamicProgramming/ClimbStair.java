package dynamicProgramming;

/*
 * https://leetcode.com/submissions/detail/492507955/
 * */
public class ClimbStair {
    /*
     * Time: O(n)
     * Space: O(n)
     * */
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        
        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        
        for(int stair = 2; stair <= n; stair++){
            ways[stair] = ways[stair - 1] + ways[stair - 2];
        }
        return ways[n];
    }
}