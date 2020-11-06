package numberTheory;
import java.util.Scanner;

public class Income {
	int MOD = 1000000007;
	
	/*
	 * O(logn)*/
	public long getIncome(long f0, long f1, long n) {
		if(n == 0) {
			return f0;
		}
		
		if(n == 1) {
			return f1;
		}
		
		long g0 = f0 + 1;
		long g1 = f1 + 1;
		Fibonacci fb = new Fibonacci();
		long fib1 = fb.fib(n);
		long fib2 = fb.fib(n -1);
		
		Exponent exp = new Exponent();
		long fib1Mod = exp.modExpIt(g1, fib1, MOD);
		long fib2Mod = exp.modExpIt(g0, fib2, MOD);
		
		long gn = (fib1Mod * fib2Mod) % MOD;
		long fn = gn - 1;
		return fn;
	}
	
	/*
	 * O(n)*/
	public long getIncomeN(long f0, long f1, long n) {
		if(n == 0) {
			return f0;
		}
		
		if(n == 1) {
			return f1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Income inc = new Income();
		long T = sc.nextLong();
		
		long f0, f1, n;
		for(int i = 0; i < T; i++) {
			f0 = sc.nextLong();
			f1 = sc.nextLong();
			n = sc.nextLong();
			System.out.println(inc.getIncome(f0, f1, n));
		}
	}
}