package fenwick;

import java.util.Scanner;

public class Incseq {
	int[] A;
	public Incseq(int[] A) {
		this.A = A;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] A = new int[n];
		for(int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		
		Incseq is = new Incseq(A);
		System.out.println(is.countIS(k));
	}

	public long countIS(int k) {
		
		return 0;
	}
}
