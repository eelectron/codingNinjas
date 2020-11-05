package numberTheory;

import java.util.Scanner;

public class BoringFactorial {
	
	public long modFactorial(long n, long p) {
		if(n == 0) {
			return 1;
		}
		
		if(n == p - 1) {
			return p - 1;
		}
		
		if(n >= p) {
			return 0;
		}
		
		Exponent exp = new Exponent();
		
		long ans = -1;
		for(long i = n + 1; i <= p - 1; i++) {
			ans = (ans * exp.modExpIt(i, p - 2, p)) % p;
		}
		ans = ans + p;
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoringFactorial bor = new BoringFactorial();
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			long n = sc.nextLong();
			long p = sc.nextLong();
			System.out.println(bor.modFactorial(n, p));
		}
	}
}
