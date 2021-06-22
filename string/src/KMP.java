package string.src;

public class KMP {
	public KMP() {
		
	}
	
	public int[] getLPS(String P) {
		int n = P.length();
		int[] lps = new int[n];
		lps[0] = 0;
		int k = 0;
		for(int i = 1; i < n; i++) {
			k = lps[i - 1];
			while(k > 0 && P.charAt(k) != P.charAt(i)) {
				k = lps[k - 1];
			}
			
			if(P.charAt(k) == P.charAt(i)) {
				k += 1;
			}
			lps[i] = k;
		}
		return lps;
	}
	
	public int find(String T, String P) {
		int n = T.length();
		int[] lps = getLPS(P);
		
		int m = P.length();
		int q = 0;
		for(int i = 0; i < n; i++) {
			while(q > 0 && P.charAt(q) != T.charAt(i)) {
				q = lps[q];
			}
			
			if(P.charAt(q) == T.charAt(i)) {
				q = q + 1;
			}
			
			if(q == m) {
				return i - m + 1;
			}
		}
		return -1;
	}
}
