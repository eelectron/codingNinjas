package numberTheory;

public class Fibonacci {
	int[][] M = {{1, 1}, {1, 0}};
	int MOD = 1000000007;
	public long fib(long n) {
		if(n == 0) {
			return 0;
		}
		
		int[][] A = {{1, 1}, {1, 0}};
		power(A, n - 1);
		return A[0][0];
	}
	
	public void power(int[][] A, long n) {
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
	public void multiply(int[][] A, int[][] B) {
		int p = A.length, q = A[0].length, r = B.length, s = B[0].length;
		if(q != r) {
			return;
		}
		
		int[][] C = new int[p][s];
		for(int i = 0; i < p; i++) {
			for(int j = 0; j < s; j++) {
				for(int k = 0; k < q; k++) {
					C[i][j] += A[i][k] * B[k][j];
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
