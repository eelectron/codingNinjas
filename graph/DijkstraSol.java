package graph;

import java.util.*;

class DistNode implements Comparable<DistNode>{
	int v;
    double d;
    DistNode(int v, double d){
        this.v = v;
        this.d = d;
    }
    
    public int compareTo(DistNode other){
        if(d < other.d) return -1;
        if(d > other.d) return 1;
        return 0;
    }
    
    public String toString() {
    	return String.format("%d %.2f", v, d);
    }
}

class Dijkstra{
    double[] distTo;
    boolean[] vis;
    int src;
    Dijkstra(Graph G, int src){
        this.src = src;
        distTo = new double[G.V()];
        vis = new boolean[G.V()];
        
        for(int i = 0; i < G.V(); i++){
        	distTo[i] = Double.POSITIVE_INFINITY;    
        }
        distTo[src] = 0;
        
        PriorityQueue<DistNode> pq = new PriorityQueue<DistNode>();
        pq.add(new DistNode(src, 0));
        
        int n = 0;
        while(pq.isEmpty() == false){
            // get min distance node
            DistNode dn = pq.poll();
            if(vis[dn.v] == false){
            	n += 1;
                vis[dn.v] = true;
                if(dn.d < distTo[dn.v]){
                    distTo[dn.v] = dn.d;
                } 
                
                Iterable<Edge<Integer>> edges = G.adj(dn.v);
                // add adj node to queue
                for(Edge<Integer> e : edges){
					int v = e.other(dn.v);
                    if(vis[v] == false){
                    	pq.add(new DistNode(v, dn.d + e.weight()));    
                    }
                }
            }
        }
    }
    
    public double getDistTo(int v){
        return distTo[v];
    }
}

public class DijkstraSol {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        Graph g = new Graph(V);
        int u, v;
        float w;
        for(int i = 0; i < E; i++){
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextFloat();
            if(u == v || w == 0){
                continue;
            }
            Edge e = new Edge(Math.min(u, v), Math.max(u, v), w);
            g.addEdge(e);
        }
		
        Dijkstra dj = new Dijkstra(g, 0);
        
        // print distances
        for(int i = 0; i < g.V(); i++){
            System.out.format("%d %d\n", i, (int)dj.getDistTo(i));
        }
	}
}
