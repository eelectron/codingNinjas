package numberTheory;

import java.util.Scanner;

public class CubicSquare {
	public long mod(long a, String b, long c) {
		long res = 1, n = b.length();
		for(int i = (int)n - 1; i >= 0; i--) {
			if(b.charAt(i) == '0') {
				
			}
			else if(b.charAt(i) == '1') {
				res = (res * a) % c;
			}
			else {
				res = ((((res * a) % c) * a) % c);
			}
			a = (((a * a) % c) * a) % c;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CubicSquare cs = new CubicSquare();
		
		long T = sc.nextLong();
		long a, c;
		String b;
		for(int i = 0; i  <T; i++) {
			a  = sc.nextLong();
			b = sc.next();
			c = sc.nextLong();
			System.out.println(cs.mod(a, b, c));
		}
	}
}
