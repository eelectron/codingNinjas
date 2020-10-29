package dpBitMasking;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Ghost {
	int n;
	public Ghost(int n) {
		this.n = n;
	}
	
	public long countPerm() {
		HashSet<Integer> set = new HashSet<Integer>();
		long[] memo = new long[1<<n];
		Arrays.fill(memo, -1);
		
		long ans = countPermRecBit(0, memo);
		return ans;
	}
	
	private long countPermRecBit(int set, long[] memo) {
		if(set == ((1<<n) - 1)) {
			return 1;
		}
		
		if(memo[set] != -1) {
			return memo[set];
		}
		
		long ans = 0, ci;
		for(int i = 1; i <= n; i++) {
			boolean isValid = true;
			ci = i;
			if((set & (1 << (i - 1))) != 0) {
				isValid = false;
			}
			
			for(int j = 1; j <= n; j++) {
				if( (set & (1 << (j - 1))) != 0) {
					if((j & ci) == ci) {
						isValid = false;
						break;
					}
				}
				
			}
			
			if(isValid) {
				ans += countPermRecBit(set | (1 << (i - 1)), memo);
			}
		}
		memo[set] = ans;
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Ghost gh = new Ghost(n);
		System.out.println(gh.countPerm());
	}
}