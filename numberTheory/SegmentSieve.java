package numberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class SegmentSieve {
	long SIZE = Integer.MAX_VALUE;
	boolean[] primes;
	public SegmentSieve() {
		int rr = (int)Math.sqrt((int)SIZE);
		primes = new boolean[rr + 1];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		
		for(int i = 2; i * i < primes.length; i++) {
			if(primes[i] == false) {
				continue;
			}
			
			for(int j = i * i; j < primes.length; j += i) {
				primes[j] = false;
			}
		}
	}
	
	public void printPrimesInRange(long a, long b) {
		long range = b - a + 1;
		boolean[] seg = new boolean[(int)range];
		Arrays.fill(seg, true);
		
		for(int i = 2; i * i <= b; i++) {
			if(primes[i] == false) {
				continue;
			}
			
			for(int j = i * 2; j <= b; j += i) {
				if(j >= a && j <= b) {
					seg[(int)(j - a)] = false;
				}
			}
		}
		
		for(int i = 0; i < seg.length; i++) {
			if(seg[i]) {
				System.out.println(i + a);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		SegmentSieve ss = new SegmentSieve();
		
		for(int i = 0; i < T; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			ss.printPrimesInRange(x, y);
		}
	}
}
