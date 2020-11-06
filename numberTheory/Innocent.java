package numberTheory;

import java.util.Scanner;

public class Innocent {
	long MOD = 1000000007;
	int SIZE = 1000000;
	long[] fac;
	Exponent exp;
	public Innocent() {
		exp = new Exponent();
		fac = new long[SIZE + 1];
		fac[0] = 1;
		for(int i = 1; i < fac.length; i++) {
			fac[i] = (fac[i - 1] % MOD * i % MOD) % MOD;
		}
	}
	
	/*
	 * ans = C(n, k) * 2 ^k 
	 * ans = ans % MOD*/
	public long ways(long n, long k) {
		// 2^k % m
		long a = exp.modExpIt(2, k, MOD);
		
				
		// n! % m
		long b = fac[(int)n];
		
		//((k! % m)^(m - 2)) % m
		long c = fac[(int)k];
		c = exp.modExpIt(c, MOD - 2, MOD);
		
		// ((n - k)! % m)^(m - 2) % m
		long d = fac[(int)(n - k)];
		d = exp.modExpIt(d, MOD - 2, MOD);
		
		long ans = (a * b) % MOD;
		ans = (ans * c) % MOD;
		ans = (ans * d) % MOD;
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Innocent inc = new Innocent();
		
		long T = sc.nextLong();
		long n, k;
		for(long i = 0; i < T; i++) {
			n = sc.nextLong();
			k = sc.nextLong();
			System.out.println(inc.ways(n, k));
		}
	}
}