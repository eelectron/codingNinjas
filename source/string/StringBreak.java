package source.string;

import java.util.Arrays;

public class StringBreak {
	  public boolean checkIfCanBreak(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        char[] a = s1.toCharArray();
        Arrays.sort(a);
        
        char[] b = s2.toCharArray();
        Arrays.sort(b);
        
        char[] temp = null;
        if(b[n - 1] > a[m - 1]){
            temp = a;
            a = b;
            b = temp;
        }
        
        for(int i = 0; i < m; i++){
            //System.out.println(a[i] + " " + b[i]);
            if(a[i] < b[i]){
                return false;
            }
        }
        return true;
    }
	  
	public static void main(String[] args) {
		String s1 = "pazunsabwlseseeiimsmftchpafqkquovuxhhkpvphw";
		String s2 = "nkrtxuiuhbcyqulfqyzgjjwjrlfwwxotcdtqsmfeing";
		
		StringBreak sb = new StringBreak();
		System.out.println(sb.checkIfCanBreak(s1, s2));
	}
}
