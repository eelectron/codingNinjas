package problem;

import java.util.Scanner;

public class Transportation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, t;
		n = sc.nextInt();
		t = sc.nextInt();
		
		int[] A = new int[n + 1];
		for(int i = 1; i < n; i++) {
			A[i] = sc.nextInt();
		}
		
		int x = 1;
		boolean canReach = false;
		while(x <= n) {
			if(x == t) {
				canReach = true;
				break;
			}
			
			if(x == n) {
				break;
			}
			x = x + A[x];
		}
		
		if(canReach) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}
