package problem;

import java.util.HashSet;
import java.util.Scanner;

import graph.Edge;
import graph.Graph;

public class EdgesMST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V, E;
		V = sc.nextInt();
		E = sc.nextInt();
		
		HashSet<Edge<Integer>> edges = new HashSet<Edge<Integer>>();
		
		// create graph
		Graph<Integer> G = new Graph<Integer>(V);
		int u, v, w;
		for(int i = 0; i < E; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			w = sc.nextInt();
			G.addEdge(u, v, w);
			G.addEdge(v, u, w);
			edges.add(new Edge(u, v, w));
		}
	}
}