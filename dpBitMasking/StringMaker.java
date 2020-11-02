package dpBitMasking;

import java.util.Arrays;
import java.util.Scanner;

public class StringMaker {
	String a, b, c;
	long MOD = 1000000007;
	public StringMaker(String a, String b, String c) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public long countWays() {
		int m = a.length();
		int n = b.length();
		int k = c.length();
		
		long[][][] memo = new long[m + 1][n + 1][k + 1];
		for(int i = 0; i <= m; i++) {
			for(int j = 0; j <= n; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}
		
		long ans = countWaysRec(m, n, k, memo);
		return ans;
	}
	
	private long countWaysRec(int p, int q, int r, long[][][] memo) {
		if(r <= 0) {
			return 1;
		}
		
		if(memo[p][q][r] != -1) {
			return memo[p][q][r];
		}
		
		long ans = 0;
		for(int i = p - 1; i >= 0; i--) {
			if(a.charAt(i) == c.charAt(r - 1)) {
				ans += countWaysRec(i, q, r - 1, memo);
			}
		}
		
		for(int i = q - 1; i >= 0; i--) {
			if(b.charAt(i) == c.charAt(r - 1)) {
				ans += countWaysRec(p, i, r - 1, memo);
			}
		}
		memo[p][q][r] = ans;
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a,b, c;
		a = sc.next();
		b = sc.next();
		c = sc.next();
		
		StringMaker sm = new StringMaker(a, b, c);
		System.out.println(sm.countWays());
	}
}