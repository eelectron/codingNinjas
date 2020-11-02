package numberTheory;

import java.util.Scanner;

public class Sachin {
	public Sachin() {
		
	}
	
	public long ways(long a, long b, long d) {
		if(d == 0) {
			return 1;
		}
		
		GCD go = new GCD();
		long g = go.gcd(a, b);
		if(d % g != 0){		
			return 0;		// d must be a multiple of g
		}
		
		a /= g;
		b /= g;
		d /= g;
		
		long mi = modInverse(b, a);
		
		long y1 = ((d % a) * mi) % a;
		if(d < b * y1) {
			return 0;
		}
		
		long n = (d - b * y1)/ (a * b);
		return n + 1;
	}
	
	private long modInverse(long a, long n) {
		// TODO Auto-generated method stub
		ExtendedEuclid ee = new ExtendedEuclid();
		Node nd = ee.gcd(a, n);
		long m = (nd.x % n + n) % n;
		return m;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		long a, b, d;
		for(int i = 0 ; i < T; i++) {
			a = sc.nextLong();
			b = sc.nextLong();
			d = sc.nextLong();
			Sachin sa = new Sachin();
			System.out.println(sa.ways(a, b, d));
		}
	}
}