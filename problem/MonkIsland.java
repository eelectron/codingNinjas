package problem;

import java.util.Scanner;
import java.util.Stack;

import graph.BFS;
import graph.Graph;

public class MonkIsland {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0;t  < T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			// bridge
			Graph<Integer> G = new Graph<Integer>(n);
			int u, v;
			for(int i = 0; i < m; i++) {
				u = sc.nextInt();
				v = sc.nextInt();
				G.addEdge(u,  v, 1);
				G.addEdge(v, u, 1);
			}
			
			BFS<Integer> bfsPath = new BFS<Integer>(G);
			Stack<Integer> path = bfsPath.getPath(1, n);
			System.out.println(path.size() - 1);
		}
	}
}
