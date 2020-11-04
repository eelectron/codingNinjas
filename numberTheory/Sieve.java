package numberTheory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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
	
	/*
	 * Return prime factors */
	public HashMap<Integer, Integer> primeFactors(long n){
		HashMap<Integer, Integer> pf = new HashMap<Integer, Integer>();
        
		int count = 0;
        long tn = n;
		for(int i = 2; (i * i <= tn); i++) {
			count = 0;
			while(n % i == 0) {
				count += 1;
				n /= i;
			}
			
			if(count > 0) {
				pf.put(i, count);
			}
		}
        
        if(n != 1){
            pf.put((int)n, 1);
        }
		return pf;
	}
	
	/*
	 * get all divisor*/
	public HashSet<Long> getDivisors(long n){
		HashSet<Long> dv = new HashSet<Long>();
		for(long i = 1; i * i <= n; i++) {
			if(n % i == 0) {
				dv.add(i);
				dv.add(n / i);
			}
		}
		return dv;
	}
}
