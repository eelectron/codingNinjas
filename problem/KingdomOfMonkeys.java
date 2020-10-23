package problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import graph.BFS;
import graph.Graph;

public class KingdomOfMonkeys {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int n, m;
			n = sc.nextInt();
			m = sc.nextInt();
			
			//create graph
			Graph<Integer> G = new Graph<Integer>(n);
			
			// add all vertices
			for(int i = 0; i < n; i++) {
				G.addVertex(i);
			}
			
			// monkey in same team
			int u, v;
			for(int i = 0; i < m; i++) {
				u = sc.nextInt() - 1;
				v = sc.nextInt() - 1;
				G.addEdge(u, v, 1);
				G.addEdge(v, u, 1);
			}
			
			int[] A = new int[n];
			
			// read banana
			for(int i = 0; i < n; i++) {
				A[i] = sc.nextInt();
			}
			
			// run bfs to find monkeys in same team
			BFS<Integer> bfs = new BFS<Integer>(G);
			Map<Integer, HashSet<Integer>> teams = bfs.getConnectedComponent();
			
			// find max golds
			long maxGolds = 0;
			
			// iterate over each team
			for(Map.Entry<Integer, HashSet<Integer>> entry : teams.entrySet()) {
				HashSet<Integer> team = entry.getValue();
				long gold = 0;
				for(Integer mon : team) {
					gold += A[mon];
				}
				maxGolds = Math.max(maxGolds, gold);
			}
			System.out.println(maxGolds);
		}
	}
}
