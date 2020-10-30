package dpBitMasking;

import java.util.Arrays;
import java.util.Scanner;

public class Dilemma {
	String[] str;
	public Dilemma(String[] str) {
		this.str = str;
	}
	
	public long minTouch() {
		int n = str.length;
		int wn = str[0].length();
		int group = ((1 << n) - 1);
		long[][] memo = new long[wn + 1][1 << n];
		for(int i = 0; i < wn; i++) {
			Arrays.fill(memo[i], -1);
		}
		
		long ans = minTouchRec(0, group, memo);
		return ans;
	}
	
	private long minTouchRec(int pos, int group, long[][] memo) {
		if((group & (group - 1)) == 0) {
			return 0;
		}
		
		if(pos >= str[0].length()) {
			return Integer.MAX_VALUE;
		}
		
		if(memo[pos][group] != -1) {
			return memo[pos][group];
		}
		
		long ans = 0;
		int g0 = 0, g1 = 0;		// put all string with 0 at str[i][pos] in one group and others with another group
		for(int i = 0; i < str.length; i++) {
			if((group & (1<<i)) != 0) {
				ans += 1;
				if(str[i].charAt(pos) == '0') {
					g0 = g0 | (1<<i);
				}
				else {
					g1 = g1 | (1<<i);
				}
			}
		}
		
		ans += minTouchRec(pos + 1, g0, memo) + minTouchRec(pos + 1, g1, memo);
		
		long ans1 = minTouchRec(pos + 1, group, memo);
		memo[pos][group] = Math.min(ans, ans1);;
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] str = new String[n];
		for(int i = 0; i < n; i++) {
			str[i] = sc.next();
		}
		
		Dilemma dm = new Dilemma(str);
		System.out.println(dm.minTouch());
	}
}