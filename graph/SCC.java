package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class SCC<T extends Comparable> {
	private HashMap<T, Boolean> marked;
	private int count;
	private HashMap<T, Integer> id;
	public SCC(Graph<T> G) {
		marked = new HashMap<T, Boolean>();
		id = new HashMap<T, Integer>();
		
		// get topological order
		Topological<T> tp = new Topological<T>(G);
		Stack<T> order = tp.getOrder();
		
		// run dfs on g reverse
		count = 0;
		Graph<T> gRev = G.reverse();
		while(order.empty() == false) {
			T v = order.pop();
			if(marked.containsKey(v) == false || marked.get(v) == false) {
				dfs(gRev, v);
				count += 1;
			}
		}
	}
	
	private void dfs(Graph<T> G, T v) {
		marked.put(v, true);
		id.put(v, count);
		for(Edge<T> e : G.adj(v)) {
			T w = e.other(v);
			if(marked.containsKey(w) == false || marked.get(w) == false) {
				dfs(G, w);
			}
		}
	}
	
	public int count() {
		return count;
	}
	
	public int id(T v) {
		return id.get(v);
	}
	
	public boolean isStronglyConnected(T u, T v) {
		return id.get(u) == id.get(v);
	}
	
	/* Return all connected component*/
	public HashMap<Integer, HashSet<T>> getAllConnectedComponent(){
		HashMap<Integer, HashSet<T>> cc = new HashMap<Integer, HashSet<T>>();
		// iterate over id
		for(Map.Entry<T, Integer> entry : id.entrySet()) {
			Integer cid = entry.getValue();
			if(cc.containsKey(cid) == false) {
				cc.put(cid, new HashSet<T>());
			}
			cc.get(cid).add(entry.getKey());
		}
		return cc;
	}
}