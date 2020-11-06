package numberTheory;

public class Fibonacci {
	long[][] M = {{1, 1}, {1, 0}};
	long MOD = 1000000007 - 1;
	public long fib(long n) {
		if(n == 0) {
			return 0;
		}
		
		long[][] A = {{1, 1}, {1, 0}};
		power(A, n - 1);
		return A[0][0];
	}
	
	private void power(long[][] A, long n) {
		if(n <= 1) {
			return;
		}
		
		power(A, n / 2);
		multiply(A, A);
		
		if(n % 2 == 1) {
			multiply(A, M);
		}
	}
	
	/*
	 * Multiply two matrix .
	 * Their dimension */
	private void multiply(long[][] A, long[][] B) {
		int p = A.length, q = A[0].length, r = B.length, s = B[0].length;
		if(q != r) {
			return;
		}
		
		long[][] C = new long[p][s];
		for(int i = 0; i < p; i++) {
			for(int j = 0; j < s; j++) {
				for(int k = 0; k < q; k++) {
					C[i][j] += A[i][k] * B[k][j];
					C[i][j] = C[i][j] % MOD;
				}
			}
		}
		
		// copy c to a
		for(int i = 0; i < p; i++) {
			for(int j = 0; j < s; j++) {
				A[i][j] = C[i][j];
			}
		}
	}
	
	public long fibSum(long n, long m) {
		long sumM = fib(m + 2);
		long sumN = fib(n + 1);
		long ans = (sumM - sumN) % MOD;
		//ans = (ans + MOD) % MOD;
		return ans;
	}
	
	public static void main(String[] args) {
		Fibonacci fb = new Fibonacci();
		System.out.println(fb.fibSum(10, 19));
	}
}
