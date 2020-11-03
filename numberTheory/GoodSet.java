package numberTheory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class GoodSet {
	int MOD = 1000000007;
	int SIZE = 10000000;
	int[] gs;
	public long count(int[] A) {
		// sort
		Arrays.sort(A);
		gs = new int[SIZE + 1];
		
		int n = A.length;
		long ans = 0;
		
		// mark A[i] ings
		for(int i = 0; i < n; i++) {
			gs[A[i]] = 1;
		}
		
		for(int i = 1; i < gs.length; i++) {
			if(gs[i] == 0) {
				continue;
			}
			
			for(int j = i; j < gs.length; j += i) {
				if(gs[i] > 0) {
					gs[j] += gs[i];
				}
			}
			
			ans  = (ans + gs[i]) % MOD;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GoodSet gs = new GoodSet();
		
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int[] A = new int[n];
			for(int j = 0; j < n; j++) {
				A[j] = sc.nextInt();
			}
			
			long ans = gs.count(A);
			System.out.println(ans);
		}
	}
}
