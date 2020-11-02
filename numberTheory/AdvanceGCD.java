package numberTheory;

import java.util.Scanner;

public class AdvanceGCD {
	String a, b;
	
	/* One of the value should have digits count < 10 .
	 * */
	public AdvanceGCD(String a, String b) {
		this.a = a;
		this.b = b;
	}
	
	public long gcd() {
		GCD gc = new GCD();
		// keep max value in a
		if(b.length() > a.length()) {
			String temp = a;
			a = b;
			b = a;
		}
		
		// apply original gcd if a has less than 9 digits
		if(a.length() < 9 && b.length() < 9) {			
			return gc.gcd(Integer.parseInt(a), Integer.parseInt(b));
		}
		
		// reduce a to be less than b
		long smallA = 0;
		long nb = Long.valueOf(b);
		for(int i = 0; i < a.length(); i++) {
			smallA = smallA * 10 + (a.charAt(i) - '0');
			smallA = smallA % nb;
		}
		
		// now apply original gcd algorithm
		long ans = gc.gcd(smallA, nb);
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			String A = sc.next();
			String B = sc.next();
			AdvanceGCD adv = new AdvanceGCD(B, A);
			System.out.println(adv.gcd());
		}
	}
}
