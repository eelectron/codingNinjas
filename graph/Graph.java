package graph;

import java.util.*;

public class Graph<T extends Comparable>{
	private final int V;
    private int E;
    private HashMap<T, HashSet<Edge<T>>> adj;
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = new HashMap<T, HashSet<Edge<T>>>(V);
    }
    
    public void addEdge(Edge<T> e){
        T u = e.either(), v = e.other(u);
        if(adj.get(u) == null) {
        	adj.put(u, new HashSet<Edge<T>>());
        }
        
        if(adj.get(v) == null) {
        	adj.put(v, new HashSet<Edge<T>>());
        }
        adj.get(u).add(e);
        adj.get(v).add(e);
        
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
    	adj.get(dst).add(e);
    }
    
    public int V(){
        return V;
    }
    
    public int E(){
        return E;
    }
    
    public Iterable<Edge<T>> adj(T v){ 
        return adj.get(v); 
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