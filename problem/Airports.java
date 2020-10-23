package problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import graph.Edge;
import graph.UF;

public class Airports {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int A = sc.nextInt();
			
			//read roads
			List<Edge<Integer>> roads = new ArrayList<Edge<Integer>>();
			int u, v, w;
			for(int i = 0;i < m; i++) {
				u = sc.nextInt() - 1;
				v = sc.nextInt() - 1;
				w = sc.nextInt();
				Edge<Integer> e = new Edge<Integer>(u, v, w);
				roads.add(e);
			}
			
			long minCost = 0;	// make airport in every city
			Collections.sort(roads);
			
			UF uf = new UF(n);
			for(int i = 0; i < roads.size(); i++) {
				Edge<Integer> road = roads.get(i);
				u = road.either();
				v = road.other(u);
				if(road.weight() <= A) {
					if(uf.isConnected(u, v) == false) {
						uf.union(u, v);
						minCost += road.weight();
					}
				}
			}
			
			minCost += A * uf.countSets();
			System.out.println("Case #" + (t + 1) + " " + minCost + " " + uf.countSets());
		}
	}
}
