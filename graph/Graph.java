package graph;
import java.util.*;

public class Graph<T extends Comparable>{
	private final int V;
    private int E;
    private HashMap<T, HashSet<Edge<T>>> adj;
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = new HashMap<T, HashSet<Edge<T>>>();
    }
    
    public void addEdge(Edge<T> e){
        T u = e.either(), v = e.other(u);
        if(adj.containsKey(u) == false) {
        	adj.put(u, new HashSet<Edge<T>>());
        }
        
        if(adj.containsKey(v) == false) {
        	adj.put(v, new HashSet<Edge<T>>());
        }
        adj.get(u).add(e);
        E += 1;
    }
    
    public void addEdge(T src, T dst, float w) {
    	Edge<T> e = new Edge<T>(src, dst, w);
    	if(adj.containsKey(src) == false) {
    		adj.put(src, new HashSet<Edge<T>>());
    	}
    	
    	if(adj.containsKey(dst) == false) {
    		adj.put(dst, new HashSet<Edge<T>>());
    	}
    	adj.get(src).add(e);
    }
    
    public Graph reverse() {
    	Graph<T> gRev = new Graph<T>(V);
    	
    	// iterate over original graph and add its edge
    	// reversed in gRev
    	for(Map.Entry<T, HashSet<Edge<T>>> entry: adj.entrySet()) {
    		HashSet<Edge<T>> edges = entry.getValue();
    		// iterate over edges
    		for(Edge<T> e: edges) {
    			gRev.addEdge(e.reverse());
    		}
    	}
    	return gRev;
    }
    
    public int V(){
        return V;
    }
    
    public int E(){
        return E;
    }
    
    public Iterable<Edge<T>> adj(T v){
    	HashSet<Edge<T>> edges = adj.get(v);
    	if(edges == null) {
    		return new HashSet<Edge<T>>();
    	}
        return edges; 
    }
    
    public void addVertex(T v) {
    	if(adj.containsKey(v) == false) {
    		adj.put(v, new HashSet<Edge<T>>());
    	}
    }
    
    public boolean contains(T v) {
    	return adj.containsKey(v);
    }
    
    public Set<T> getVertices(){
    	return adj.keySet();
    }
    
    public HashSet<Edge<T>> edges(){
    	HashSet<Edge<T>> ed = new HashSet<Edge<T>>();
        T x, y;
        for(Map.Entry<T, HashSet<Edge<T>>> entry: adj.entrySet()){
            for(Edge<T> e : entry.getValue()){
                x = e.either();
                y = e.other(x);
                ed.add(e);
            }
        }
        return ed;
    }
}