package graph;
import java.util.*;

class KruskalMST<T extends Comparable>{
    private List<Edge<T>> mst;
    private float weight;
    KruskalMST(Graph<T> g){
        weight = 0;
        mst = new ArrayList<Edge<T>>();
        PriorityQueue<Edge<T>> pq = new PriorityQueue(g.edges());
        UF uf = new UF(g.V());
        while(pq.isEmpty() == false && mst.size() < g.V() - 1){
            Edge<T> e = pq.poll();
            T u = e.either(), v = e.other(u);
            if(uf.isConnected(u, v) == true){
                continue;
            }
            uf.union(u, v);
            mst.add(e);
            weight += e.weight();
        }
    }
    
	List<Edge<T>> edges(){
        return mst;
    }   
    
    double weight(){
        return weight;
    }
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        
        //read edge
        Graph<Integer> g = new Graph<Integer>(V);
        int u, v;
        float w;
        for(int i = 0; i < E; i++){
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextFloat();
            Edge e = new Edge(Math.min(u, v), Math.max(u, v), w);
            g.addEdge(e);
        }
        
        KruskalMST<Integer> mst = new KruskalMST<Integer>(g);
        Iterable<Edge<Integer>> edges = mst.edges();
        for(Edge e: edges){
            System.out.println(e);
        }
	}
}