package numberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class CubeFree {
	int MAXSIZE;
	boolean[] cubes;
	int[] pos;
	public CubeFree(int MAXSIZE) {
		this.MAXSIZE = MAXSIZE;
		cubes = new boolean[MAXSIZE + 1];
		Arrays.fill(cubes, true);
		cubes[0] = false;
		
		pos = new int[MAXSIZE + 1];
		
		// mark all num which have cubes , the remainng are cube free
		Sieve sv = new Sieve(MAXSIZE);
		boolean[] primes = sv.getPrimes();
		
		for(int i = 2; i < primes.length && (i * i * i < cubes.length); i++) {
			if(primes[i] == false) {
				continue;
			}
			
			long cube = i * i * i;
			for(int j = 1; (j < MAXSIZE + 1) && (j * cube < cubes.length); j++) {
				int x = j * (int)cube;
				if(x < 0) {
					break;
				}
				cubes[x] = false;
			}
		}
		
		// save their positions
		int p = 1;
		for(int i = 1; i < pos.length; i++) {
			if(cubes[i]) {
				pos[i] = p;
				p += 1;
			}
		}
	}
	
	public int isCubeFree(int n) {
		if(cubes[n] == false) {
			return -1;
		}
		return pos[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int MAXSIZE = 1000000;
		CubeFree cf = new CubeFree(MAXSIZE);
		for(int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int ans = cf.isCubeFree(n);
			System.out.print("Case " + (i + 1) + ": ");
			if(ans > 0) {
				System.out.println(ans);
			}
			else {
				System.out.println("Not Cube Free");
			}
		}
	}
}
