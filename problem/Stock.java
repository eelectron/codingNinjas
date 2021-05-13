package problem;

/*
 * https://leetcode.com/submissions/detail/492538012/
 * */
public class Stock {
    /*
    Time : O(n)
    Space: O(1)
    */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        
        int pn = prices.length;
        int maxProfit = 0;
        int minBuySoFar = prices[0];
        for(int i = 0; i < pn; i++){
            minBuySoFar = Math.min(minBuySoFar, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minBuySoFar);
        }
        return maxProfit;
    }
}