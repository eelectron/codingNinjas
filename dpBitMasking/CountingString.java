package dpBitMasking;

import java.util.Scanner;

public class CountingString {
	String str;
	public CountingString(String s) {
		this.str = s;
	}
	
	/*
	 *input :  A, AA, Z, Y*/
	public long countStrings() {
		long ans = countStrings(0, str.length());
		return ans;
	}
	
	private long countStrings(int x, int y) {
		if(x >= y) {
			return 0;
		}
		
		if(y - x == 1) {
			return 'Z' - str.charAt(x);
		}
		
		long ans = 0;
		// case 1 : make first char strictly greater
		ans += ('Z' - str.charAt(x)) * ('Z' - str.charAt(x));
		
		// case 2: s[x] == s[y - 1]
		if(str.charAt(x) == str.charAt(y - 1)) {
			ans += countStrings(x + 1, y - 1);
			ans += 'Z' - str.charAt(x);
			ans += 'Z' - str.charAt(x);
		}
		else if(str.charAt(x) < str.charAt(y - 1)) {
			ans += 'Z' - str.charAt(y - 1);
		}
		else {
			ans += 'Z' - str.charAt(x) + 1;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		CountingString cs = new CountingString(s);
		System.out.println(cs.countStrings());
	}
}