package numberTheory;

import java.util.Scanner;

public class NFactor {
	int SIZE;
	int[] A;
	int d;
	int[][] AN;
	public NFactor(int n, int d) {
		this.SIZE = n;
		this.d = d;
		A = new int[SIZE + 1];
		AN = new int[SIZE + 1][d + 1];
		
		// count num of primes contained in a number
		Sieve sv = new Sieve(SIZE + 1);
		boolean[] primes = sv.getPrimes();
		
		for(int i = 2; i < primes.length; i++) {
			
			// if i is prime then all multiple of i contains i as prime factor !
			if(primes[i] == false) {
				continue;
			}
			
			for(int j = i; j < A.length; j += i) {
				A[j] += 1;
			}
		}
		
		// prefix sum
		AN[1][0] = 1;
		
		for(int i = 2; i < AN.length; i++) {
			// copy prev values
			for(int j = 0; j <= d; j++) {
				AN[i][j] = AN[i - 1][j];
			}
			
			// add current count
			AN[i][A[i]] += 1;
		}
	}
	
	public int getCount(int a, int b, int n) {
		int ans = 0;
		ans = AN[b][n] - AN[a - 1][n];
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int SIZE = 1000000;
		int d = 10;
		NFactor nf = new NFactor(SIZE, d);
		
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = sc.nextInt();
			int ans = nf.getCount(a, b, n);
			System.out.println(ans);
		}
	}
}