package problem;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import graph.Edge;
import graph.Graph;
import graph.SCC;

public class Domino {
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			Graph<Integer> G = new Graph<Integer>(V);
			int u, v;
			for(int i = 0; i < E; i++) {
				u = sc.nextInt();
				v = sc.nextInt();
				G.addEdge(u, v, 1);
			}
			
			SCC<Integer> scn = new SCC<Integer>(G);
			// iterate over each vertex and fall reachable domino
			// At the end remaining vertices in Graph is our answer
			/*HashMap<Integer, Boolean> falled = new HashMap<Integer, Boolean>();
			for(Integer ver : G.getVertices()) {
				if(falled.containsKey(ver) == false) {
					falled.put(ver, false);
				}
				
				for(Edge<Integer> edge : G.adj(ver)) {
					Integer w = edge.other(ver);
					fall(G, w, falled);
				}
			}
			
			long minPush = 0;
			for(Map.Entry<Integer, Boolean> entry : falled.entrySet()) {
				if(entry.getValue() == false) {
					minPush += 1;
				}
			}*/
			System.out.println("t = " + t + " " + scn.count());
		}
	}
	
	static void fall(Graph<Integer> G, Integer v, HashMap<Integer, Boolean> falled) {
		falled.put(v, true);
		for(Edge<Integer> edge : G.adj(v)) {
			Integer w = edge.other(v);
			if(falled.containsKey(w) == false || falled.get(w) == false) {
				fall(G, w, falled);
			}
		}
	}
}