package biweekly36;

import java.util.Arrays;
class Mailbox {
    private long f(int start, int[] H, int k, int[][] costWithOneK, Long[][] memo){
    	  if(start >= H.length){
              return 0;
          }
          
          if(k == 0){
              if(start < H.length){
                  return Integer.MAX_VALUE;
              }
              return 0;
          }
        
        if(memo[start][k] != null) {
        	return memo[start][k];
        }
        
        long ans = Integer.MAX_VALUE, curCost = 0;;
        for(int i = start; i < H.length; i++){
            curCost = costWithOneK[start][i] + f(i, H, k - 1, costWithOneK, memo);
            ans = Math.min(ans, curCost);
        }
        memo[start][k] = ans;
        return ans;
    }
    
    public int minDistance(int[] H, int k) {
        int n = H.length;
        Arrays.sort(H);
        
        int[][] costWithOneK = new int[n][n];
        int mid = 0, cost = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                mid = i + (j - i) / 2;
                cost = 0;
                for(int p = i; p <= j; p++){
                    cost += Math.abs(H[p] - H[mid]);
                }
                costWithOneK[i][j] = cost;
            }
        }
        
        Long[][] memo = new Long[n + 1][k + 1];
        
        int start = 0;
        long ans = f(start, H, k, costWithOneK, memo);
        return (int)ans;
    }
    
    public static void main(String[] args) {
		int[] H = {1,4,8,10};
		int k = 2;
		Mailbox mb = new Mailbox();
		System.out.println(mb.minDistance(H, k));
	}
}
