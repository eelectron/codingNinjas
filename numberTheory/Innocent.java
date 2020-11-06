package numberTheory;

import java.util.Scanner;

public class Innocent {
	long MOD = 1000000007;
	public Innocent() {
		
	}
	/*
	 * ans = C(n, k) * 2 ^k 
	 * ans = ans % MOD*/
	public long ways(long n, long k) {
		// 2^k % m
		
		// n! % m
		
		//((k! % m)^(m - 2)) % m
		
		// ((n - k)! % m)^(m - 2) % m
		return 0;
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