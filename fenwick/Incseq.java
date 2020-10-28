package fenwick;

import java.util.Scanner;

public class Incseq {
	long MOD = 5000000;
	int MAXA = 100000;
	int[] A;
	public Incseq(int[] A) {
		this.A = A;
	}
	
	// O(n * k * logn)
    public long countIS(int k) {
		int n = A.length;
		
		// init bit tree
		Fenwick[] fen = new Fenwick[k + 1];
		for(int i = 1; i < k + 1; i++) {
			fen[i] = new Fenwick(MAXA + 1);
		}
		
		
		// find inc seq ending at each ai
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < k + 1; j++) {
				if(j == 1) {
					fen[j].update(A[i] + 1, j);
				}
				else {
					// count all seq of size j - 1 and whose last item is smaller than A[i]
					long count = fen[j - 1].query(A[i] + 1 - 1);
					
					// update its count
					fen[j].update(A[i] + 1, count);
				}
			}
		}
		
		// all inc seq of length k 
		long ans = fen[k].query(MAXA + 1);
		return ans;
	}
	
	// O(n * k * n)
	private long countISDp(int k) {
		int n = A.length;
		long[][] dp = new long[n][k + 1];
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < k + 1; j++) {
				if(j == 1) {
					dp[i][j] = 1;
				}
				else {
					for(int m = 0; m < i; m++) {
						if(A[m] < A[i]) {
							dp[i][j] = (dp[i][j] + dp[m][j - 1]) % MOD;
						}
					}
				}
			}
		}
		
		// count all
		long ans = 0;
		for(int i = 0; i < n; i++) {
			ans = (ans + dp[i][k]) % MOD;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] A = new int[n];
		for(int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		
		Incseq is = new Incseq(A);
		System.out.println(is.countIS(k));
	}
}