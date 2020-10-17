package graph;
import java.util.*;

class UF{
    private int[] parent;
    private int[] treeSize;
    UF(int n){
        parent = new int[n];
        treeSize = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
            treeSize[i] = 1;
        }
    }
    
    private int find(int node){
        int x = node;
        while(x != parent[x]){
            x = parent[x];
        }
        return x;
    }
    
	public void union(int u, int v){
        int ru = find(u);
        int rv = find(v);
        if(isConnected(u, v) == true){
            return;
        }
        
        if(treeSize[ru] >= treeSize[rv]){
            parent[rv] = ru;
            treeSize[ru] += treeSize[rv];
        }
        else{
            parent[ru] = rv;
            treeSize[rv] += treeSize[ru];
        }
    }    
    
    public boolean isConnected(int u, int v){
        int ru = find(u);
        int rv = find(v);
        return ru == rv;
    }
}

class KruskalMST{
    private List<Edge> mst;
    private float weight;
    KruskalMST(Graph g){
        weight = 0;
        mst = new ArrayList<Edge>();
        PriorityQueue<Edge> pq = new PriorityQueue(g.edges());
        UF uf = new UF(g.V());
        while(pq.isEmpty() == false && mst.size() < g.V() - 1){
            Edge e = pq.poll();
            int u = e.either(), v = e.other(u);
            if(uf.isConnected(u, v) == true){
                continue;
            }
            uf.union(u, v);
            mst.add(e);
            weight += e.weight();
        }
    }
    
	Iterable<Edge> edges(){
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
        Graph g = new Graph(V);
        int u, v;
        float w;
        for(int i = 0; i < E; i++){
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextFloat();
            Edge e = new Edge(Math.min(u, v), Math.max(u, v), w);
            g.addEdge(e);
        }
        
        KruskalMST mst = new KruskalMST(g);
        Iterable<Edge> edges = mst.edges();
        for(Edge e: edges){
            System.out.println(e);
        }
	}
}