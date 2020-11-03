package numberTheory;

import java.util.Scanner;

public class Factorial {
	long MOD = 1000000007;
	
	public long numOfDivisor(long n) {
		long ans = 1;
		
		// get all prime between [1, n]
		Sieve sv = new Sieve(n);
		boolean[] primes = sv.getPrimes();
		
		for(int i = 0; i < n + 1; i++) {
			if(primes[i] == false) {
				continue;
			}
			
			long count = 0, k = i;
			while((n / k) > 0) {
				count = (count + (n / k)) % MOD;
				k = k * i;
			}
			ans = ans * (count + 1) % MOD;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		Factorial fac = new Factorial();
		for(int i = 0; i < T; i++) {
			long n = sc.nextLong();
			System.out.println(fac.numOfDivisor(n));
		}
	}
}
