package string.src;

public class LongestUniformSubstring {
    public int[] longestUniformSubstring(String input) {
        int longestStart = -1;
        int longestLength = 0;
        if(input == null || input.length() == 0){
          return new int[]{ longestStart, longestLength };
        }
        
        // todo: implement the longestUniformSubstring logic
        int n = input.length();
        
        int ch         = -1;	// assuming -1 is invalid input character
        int count       = 0;
        int charIndex   = -1;
        for(int i = 0; i < n; i++){
          if(input.charAt(i) == ch){
            count += 1;
          }
          else{
              // reset the count and char
              ch = input.charAt(i);
              count = 1;
              charIndex = i;
          }
          
          // possible candidate for answer
          if(count > longestLength){
            longestLength = count;
            longestStart = charIndex;
          }
        }
        return new int[]{longestStart, longestLength};
    }
}
