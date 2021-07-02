package string.src;

/*
 * 
 *  https://leetcode.com/submissions/detail/492499504/
 *  */
public class LongestPalindromicSubstring {
    /* 
     * Time : O(n^2)
    Space : O(n^2)
    */
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for(int i = 0; i < n; i++){
            isPal[i][i] = true;
        }
        
        int maxLen = 1;
        int si = 0, ei = 0;
        for(int i = 0; i + 1 < n; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                isPal[i][i + 1] = true;
                maxLen = 2;
                si = i;
                ei = i + 1;
            }
        }
        
        for(int len = 3; len <= n; len++){
            for(int i = 0; i + len - 1 < n; i++){
                if(s.charAt(i) == s.charAt(i + len - 1) && isPal[i + 1][i + len - 2] == true){
                    isPal[i][i + len - 1] = true;
                    maxLen = len;
                    si = i;
                    ei = i + len - 1;
                }
                else{
                    isPal[i][i + len - 1] = false;
                }
            }
        }
        return s.substring(si, ei + 1);
    }
    
    public static void main(String[] args){
    	LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
        sol.testLongestPalindrome();
      }
      
      public void testLongestPalindrome(){
    	LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
        boolean res = true;
        res = res && ("m".equals(sol.longestPalindrome("m")));
        res = res && ("cac".equals(sol.longestPalindrome("bcacd")));
        res = res && ("a".equals(sol.longestPalindrome("abcd")));
        res = res && ("aaaa".equals(sol.longestPalindrome("aaaa")));
        res = res && ("".equals(sol.longestPalindrome("")));
        if(res){
          System.out.println("All test passed .");
        }
        else{
          System.out.println("At least one test is failing .");
        }
      }
}