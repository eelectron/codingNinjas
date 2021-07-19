package string.src;

public class CompressAB {
    public static void main(String[] args) {
        CompressAB cab = new CompressAB();
        System.out.println(cab.compress("abab"));
    }
    
    public String compress(String s) {
    	if(s == null) {
    		return s;
    	}
    	
        //String res = compressHelper(s, s.length());
    	String res = compressHelperIterative(s);
        return res;
    }
    
    private String compressHelper(String s, int n) {
    	if(n <= 1) {
    		return s.substring(0, n);
    	}
    	
    	int end = 0;
    	int totalLen = 0, half = 0;
    	String firstPart = "", secondPart = "";
    	for(int i = n - 1; i >= 0; i--) {
    		totalLen = i + 1;
    		half = totalLen / 2;
    		firstPart = s.substring(0, half);
    		secondPart = s.substring(half, totalLen);
    		if(firstPart.equals(secondPart)) {
    			return compressHelper(s, half) + "*" + s.substring(n - end , n);
    		}
    		else {
    			end += 1;
    		}
    	}
    	
    	// nothing is repeated
    	return s.substring(0, n);
    }
    
    private String compressHelperIterative(String s) {
    	if(s == null || s.length() <= 1) {
    		return s;
    	}
    	
    	int n = s.length();
    	String res = "";
    	
    	int totalLen = 0, half = 0;
    	String firstPart = "", secondPart = "";
    	
    	int i = n - 1;
    	while(i >= 1) {
    		totalLen = i + 1;
    		half = totalLen / 2;
    		
    		firstPart = s.substring(0, half);
    		secondPart = s.substring(half, totalLen);
    		
    		if(firstPart.equals(secondPart)) {
    			res = "*" + res;
    			i = half - 1;
    		}
    		else {
    			res = s.charAt(i) + res;
    			i -= 1;
    		}
    	}
    	
    	res = s.charAt(0) + res;
    	return res;
    }
}