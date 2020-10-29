package dpBitMasking;

import java.util.*;

public class Candy {
	int n;
	int[][] likes;
	public Candy(int n, int[][] likes) {
		this.n = n;
		this.likes = likes;
	}
	
	public long ways() {
        long[][] memo = new long[n][1<<n];
        for(int  i = 0; i < n; i++){
            Arrays.fill(memo[i], -1);
        }
        
		long ans = waysHRec(0, 0, memo);
		return ans;
	}
	
	private long waysHRec(int p, int candyAssigned, long[][] memo) {
		if(p >= n) {
			return 1;
		}
		
        if(memo[p][candyAssigned] != -1){
            return memo[p][candyAssigned];
        }
        
		long ans = 0;
		// try each candy
		for(int i = 0; i < n; i++) {
			
			// check if person likes i'th candy and its not been assigned to anyone
			if(likes[p][i] == 1 && (candyAssigned & (1 << (n - (i + 1)))) == 0) {
				ans += waysHRec(p + 1, (candyAssigned | (1 << (n - (i + 1)))), memo);
			}
		}
        memo[p][candyAssigned] = ans;
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] likes = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				likes[i][j] = sc.nextInt();
			}
		}
		
		Candy cd = new Candy(n, likes);
		System.out.println(cd.ways());
	}
}