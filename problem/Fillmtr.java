package problem;

import java.util.Arrays;
import java.util.Scanner;

import graph.Graph;
import graph.TwoColor;

public class Fillmtr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N, Q;
			N = sc.nextInt();
			Q = sc.nextInt();
			
			int[][] B = new int[N][N];
			// init with empty cell 
			for(int i = 0; i < N; i++) {
				Arrays.fill(B[i], -1);
			}
			
			// read matrix val
			for(int i = 0; i < Q; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				int v = sc.nextInt();
				
				B[x][y] = v;
			}
			
			//System.out.println();
			boolean check = sanityCheck(B);
			if(check == false) {
				System.out.println("no");
				continue;
			}
			
			Graph<Integer> G  = new Graph<Integer>(N);
			for(int i = 0; i < N; i++) {
				for(int j= 0; j < i; j++) {
					if(B[i][j] == 1) {
						G.addEdge(i, j, 1);
						G.addEdge(j, i, 1);
					}
				}
			}
			
			// check if graph is bipartite
			TwoColor<Integer> tc = new TwoColor<Integer>(G);
			if(tc.isBipartite()) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
	
	static boolean sanityCheck(int[][] B) {
		int N = B.length;
		// check diag
		for(int i = 0; i < N; i++) {
			if(B[i][i] > 0) {
				return false;
			}
			B[i][i] = 0;
		}
		
		// check sym
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(B[i][j] != -1 && B[j][i] == -1) {
					B[j][i] = B[i][j];
				}
				
				if(B[i][j] != -1 && B[j][i] != -1) {
					if(B[i][j] != B[j][i]) {
						return false;
					}
				}
			}
		}
		return true;
	}
}