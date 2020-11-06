package numberTheory;

import java.util.HashSet;
import java.util.Scanner;

public class GCDExtreme {
	int SIZE = 1000001;
	long[] gcdSum;
	public GCDExtreme() {
		gcdSum = new long[SIZE + 1];
		
		//Sieve sv = new Sieve(10);	// 10 does not play role
		EulerTotient et = new EulerTotient(SIZE);
		
		// gcdSum[i] = gcdSum[i - 1] + gcd(1, i) + gcd(2, i) + ... + gcd(i - 1, i)
		for(int i = 1; i < SIZE + 1; i++) {
			for(int j = 2; i * j < SIZE + 1; j++) {
				gcdSum[i * j] += i * et.getPhi(j);
			}
		}
		
		for(int i = 3; i < SIZE + 1; i++) {
			gcdSum[i] += gcdSum[i - 1];
		}
	}
	
	public long gcdExtreme(long n) {
		long sum = 0;
		sum = gcdSum[(int)n];
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GCDExtreme ge = new GCDExtreme();
		long n;
		while(true) {
			n = sc.nextLong();
			if(n == 0) {
				break;
			}
			long sum = ge.gcdExtreme(n);
			System.out.println(sum);
		}
	}
}
