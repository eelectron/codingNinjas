package numberTheory;

import java.util.HashSet;
import java.util.Scanner;

public class LcmSum {
	/*
	 * lcm(1, n) + lcm(2, n) + lcm(3, n) + ... + lcm(n, n)
	 * */
	public long getLcmsum(long n) {
		long sum = 0;
		EulerTotient et = new EulerTotient(n);
		
		Sieve sv = new Sieve(100);
		
		// get all divisors
		HashSet<Long> dv = sv.getDivisors(n);
		for(Long d : dv) {
			long dd = d;
			sum += (et.getPhi((int)dd) * dd);
		}
		
		sum += 1;
		sum *= n;
		sum /= 2;
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LcmSum ls = new LcmSum();
		int n = sc.nextInt();
		long sum = ls.getLcmsum(n);
		System.out.println(sum);
	}
}