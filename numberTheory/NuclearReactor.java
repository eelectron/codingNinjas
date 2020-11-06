package numberTheory;

import java.util.Scanner;

public class NuclearReactor {
	public long energy(long t, long m) {
		if(t == 1) {
			return 1;
		}
		
		long ans = 1;
		// t is less than m
		if(t < m) {
			for(int i = 1; i <= t; i++) {
				ans *= i;
				ans = ans % m;
			}
			return ans;
		}
		
		long mSeg = t / m;
		// find T % m
		for(long i = mSeg * m + 1; i <= t; i++) {
			ans *= i;
			ans = ans % m;
		}
		
		if(mSeg % 2 == 1) {
			ans *= (m - 1);
			ans %= m;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		NuclearReactor nr = new NuclearReactor();
		
		long T = sc.nextLong(), t, m;
		for(long i = 0; i < T; i++) {
			t = sc.nextLong();
			m = sc.nextLong();
			System.out.println(nr.energy(t, m));
		}
	}
}
