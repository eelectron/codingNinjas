package problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import graph.Edge;
import graph.Graph;
import graph.SCC;

public class Bottom {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int V, E;
			V = sc.nextInt();
			if(V == 0) {
				break;
			}
			
			E = sc.nextInt();
			
			Graph<Integer> G = new Graph<Integer>(V);
			// init Graph with vertex
			for(int i = 1; i <= V; i++) {
				G.addVertex(i);
			}
			
			//read edges
			int x, y;
			for(int i = 0; i < E; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				G.addEdge(x, y, 1);
			}
			
			// run SCC
			SCC<Integer> scn = new SCC<Integer>(G);
			
			// get all connected comp
			HashMap<Integer, HashSet<Integer>> cc = scn.getAllConnectedComponent();
			
			// find sink
			List<Integer> sinks = new ArrayList<Integer>();
			
			// iterate over each component
			for(Map.Entry<Integer, HashSet<Integer>> entry : cc.entrySet()) {
				Integer cid = entry.getKey();
				HashSet<Integer> vertices = entry.getValue();
				
				boolean isSink = true;
				// iterate over each vertex
				for(Integer v : vertices) {
					
					// iterate over each adj edge
					for(Edge<Integer> edge : G.adj(v)) {
						int w = edge.other(v);
						if(scn.id(w) != cid) {
							isSink = false;
							break;				// this component can not be a sink
						}
					}
				}
				
				// add all vertices in sink
				if(isSink) {
					for(int sx: vertices) {
						sinks.add(sx);
					}
				}
			}
			
			// sort and print sinks
			Collections.sort(sinks);
			for(int sv: sinks) {
				System.out.print(sv + " ");
			}
			System.out.println();
		}
	}
}