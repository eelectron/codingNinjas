package numberTheory;

import java.util.Arrays;

public class Sieve {
	private long n;
	private boolean[] primes;
	public Sieve(long n) {
		this.n = n;
		primes = new boolean[(int)n + 1];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		
		for(int i = 2; i * i < n + 1; i++) {
			// check if i is prime
			if(isPrime(i)) {
				primes[i] = true;
				
				// mark all multiple of prime as false
				for(int j = i * i; j < n + 1; j += i) {
					primes[j] = false;
				}
			}
		}
	}
	
	public boolean isPrime(long n) {
		if(n < 2) {
			return false;
		}
		
		for(int i = 2; i * i < n + 1; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean[] getPrimes() {
		return primes;
	}
}
