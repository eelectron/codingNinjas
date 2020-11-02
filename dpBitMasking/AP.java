package dpBitMasking;

import java.util.Arrays;
import java.util.Scanner;

public class AP {
	int MOD = 100001;
	int MAXA = 1000;
	int[] A;
	public AP(int[] A) {
		this.A = A;
	}
	
	public long countAP() {
		int n = A.length;
		if(n < 3) {
			return 2 * n;
		}
		
		long[][] dp = new long[n][2 * MAXA + 2];
		Arrays.fill(dp[0], 1);
		
		long ans = n + 1 + (n * (n - 1)) / 2;
		
		int d = A[1] - A[0] + MAXA;
		dp[1][d] = 1;
		for(int i = 2; i < n; i++) {
			for(int j = 1; j < i; j++) {
				d = A[i] - A[j] + MAXA;	
				dp[i][d] += dp[j][d];
				ans += dp[i][d];
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for(int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		
		AP ap = new AP(A);
		System.out.println(ap.countAP());
	}
}
