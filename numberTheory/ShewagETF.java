package numberTheory;

import java.util.Scanner;

public class ShewagETF {
	int SIZE = 1000000;
	Sieve sv;
	boolean[] primes;
	public ShewagETF() {
		sv = new Sieve(SIZE);
		this.primes = sv.getPrimes();
	}
	
	public double getProbability(long m, long n, long k) {
		long sz = n - m + 1;
		
		// create array for euler totient
		long[] et = new long[(int)sz];
		
		// create a array to keep bigger prime
		long[] bigPrime = new long[(int)sz];
		
		for(long i = m; i <= n; i++) {
			et[(int)(i - m)] = i;
			bigPrime[(int)(i - m)] = i;
		}
		
		for(int i = 2; i < primes.length; i++) {
			if(primes[i] == false) {
				continue;
			}
			
			// consider all multiple of prime i lie inside [m, n]
			long start = m / i;
			for(long j = start * i; j <= n; j += i) {
				if(j >= m && j <= n) {
					et[(int)(j - m)] = (et[(int)(j - m)] * (i - 1)) / i;
					
					// divide j with prime
					while(bigPrime[(int)(j - m)] % i == 0) {
						bigPrime[(int)(j - m)] /= i;
					}
				}
			}
		}
		
		// find all et divisible by k
		double count = 0;
		for(int i = 0; i < et.length; i++) {
			if(bigPrime[i] > 1) {
				et[i] = (et[i] * (bigPrime[i] - 1)) / bigPrime[i];
			}
			
			if(et[i] % k == 0) {
				count += 1;
			}
		}
		return count / sz;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ShewagETF setf = new ShewagETF();
		
		long T = sc.nextLong();
		long m, n, k;
		for(long i = 0; i < T; i++) {
			m = sc.nextLong();
			n = sc.nextLong();
			k = sc.nextLong();
			System.out.format("%.6f\n", setf.getProbability(m, n, k));
		}
	}
}
