package fenwick;

import java.util.Scanner;

public class Wave {
	long MOD = 1000000007;
	int MAXA = 100000;
	long[] bit0, bit1;
	int[] A;
	public Wave(int[] A) {
		this.A = A;
		bit0 = new long[MAXA + 1];
		bit1 = new long[MAXA + 1];
	}
	
	public long countWaveBit() {
		int n = A.length;
		long ans = 0;
		
		// init bit
		update(bit0, A[0], 1);
		update(bit1, A[0], 1);
		
		ans += 2;
		for(int i = 1; i < n; i++) {
			// get count of all subs whose last item is greater than A[i]
			long c1 = (query(bit1, MAXA) - query(bit1, A[i])) % MOD;
			c1 += MOD;
			c1 %= MOD;
			
			// get count of all subs whose last item is smaller than A[i]
			long c2 = query(bit0, A[i] - 1) % MOD;
			
			update(bit0, A[i], c1 + 1);
			update(bit1, A[i], c2 + 1);
			ans = (ans + c1 + 1) % MOD;
            ans = (ans + c2 + 1) % MOD;
		}
		
		// remove subseq of length 1
		ans -= (2 * n);
		return ans;
	}
	
	private long query(long[] bitx, int ai) {
		long count = 0;
		while(ai > 0) {
			//count += bitx[ai];
			//count %= MOD;
			count = (count % MOD + bitx[ai] % MOD) % MOD;
			ai -= (ai & -ai);
		}
		return count;
	}

	private void update(long[] bitx, int ai, long v) {
		while(ai < bitx.length) {
			//bitx[ai] += v;
		//	bitx[ai] %= MOD;
			bitx[ai] = (bitx[ai] % MOD + v % MOD) % MOD;
			ai += (ai & -ai);
		}
	}

	public long countWaveDP() {
		int n = A.length;
		long[][] dp = new long[n][2];
		dp[0][0] = 1;
		dp[0][1] = 1;
		
		long ans = 0;
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(A[i] < A[j]) {
					dp[i][0] += dp[j][1];
				}
				else if(A[i] > A[j]){
					dp[i][1] += dp[j][0];
				}
			}
			
			// count A[i] also
			dp[i][0] = (dp[i][0] + 1) % MOD;
			dp[i][1] = (dp[i][1] + 1) % MOD;
			
            ans -= 2;
			ans += dp[i][0] % MOD;
			ans += dp[i][1] % MOD;
		}
		return ans % MOD;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] A = new int[n];
		for(int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		
		Wave wv = new Wave(A);
		System.out.println(wv.countWaveBit());
	}
}