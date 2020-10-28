package dpBitMasking;

import java.util.Scanner;

public class Candy {
	int n;
	int[][] likes;
	public Candy(int n, int[][] likes) {
		this.n = n;
		this.likes = likes;
	}
	
	public long ways() {
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] likes = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				likes[i][j] = sc.nextInt();
			}
		}
		
		Candy cd = new Candy(n, likes);
		System.out.println(cd.ways());
	}
}