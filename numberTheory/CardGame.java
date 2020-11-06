package numberTheory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CardGame {
	int SIZE = 1000000000;
	boolean[] primes;
	Sieve sv;
	public CardGame() {
		this.sv = new Sieve(SIZE);
		this.primes = sv.getPrimes();
	}
	
	public long ways(int[] A, int k) {
		int n = A.length;
		long ans = 0;
		if(k == 1) {
            ans = (n * (n + 1)) / 2;
			return ans;
		}
		
		// prime fac of k
		HashMap<Integer, Integer> pfk = primeFactors(k);
		
		// initialize empty factors count with zero
		HashMap<Integer, Integer> bag = new HashMap<Integer, Integer>();
		for(Map.Entry<Integer, Integer> entry : pfk.entrySet()) {
			bag.put(entry.getKey(), 0);
		}
		
		boolean gotK = false;
		
		int i = 0, j = 0;
		HashMap<Integer, Integer> pfaj = null, pfai = null;
		while(i < n) {
			// stop when we got k
			while(j < n && gotK == false) {
				// get prime fact of A[j]
				pfaj = getFactors(A[j], pfk);
				
				gotK = true;
				
				// fill bag with factors of A[j]
				for(Map.Entry<Integer, Integer> entry : pfk.entrySet()) {
					if(pfaj.containsKey(entry.getKey())) {
						bag.put(entry.getKey(), bag.get(entry.getKey()) + pfaj.get(entry.getKey()));
					}
					
					if(bag.get(entry.getKey()) < entry.getValue()) {
						gotK = false;
					}
				}
				
				j += 1;
			}
			
			if(gotK == true && j - i > 0) {
				ans += (n - j + 1);
			}
			
			// remove A[i] fac from bag
			pfai = getFactors(A[i], pfk);
			for(Map.Entry<Integer, Integer> entry : pfk.entrySet()) {
				if(pfai.containsKey(entry.getKey())) {
					bag.put(entry.getKey(), bag.get(entry.getKey()) - pfai.get(entry.getKey()));
				}
				
				if(bag.get(entry.getKey()) < entry.getValue()) {
					gotK = false;
				}
			}
			
			i += 1;
			if(i > j) {
				j = i;
			}
		}
		return ans;
	}
	
	private HashMap<Integer, Integer> getFactors(long n, HashMap<Integer, Integer> pfk){
		HashMap<Integer, Integer> pf = new HashMap<Integer, Integer>();
		int count = 0, p = 0;
		for(Map.Entry<Integer, Integer> entry : pfk.entrySet()) {
			p = entry.getKey();
			
			count = 0;
			while(n % p == 0) {
				count += 1;
				n /= p;
			}
			
			if(count > 0) {
				pf.put(p, count);
			}
		}
		return pf;
	}
	
	/*
	 * Return prime factors 
	 * 12 = 2^2 * 3
	 * Return ([2,2], [3,1])*/
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] A = new int[n];
		for(int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		
		CardGame cg = new CardGame();
		long ans = cg.ways(A, k);
		System.out.println(ans);
	}
}