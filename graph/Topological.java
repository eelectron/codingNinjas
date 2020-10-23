package graph;

import java.util.HashMap;
import java.util.Stack;

public class Topological<T extends Comparable> {
	private HashMap<T, Boolean> marked;
	private Stack<T> order;
	public Topological(Graph<T> G) {
		marked = new HashMap<T, Boolean>();
		order = new Stack<T>();
		for(T v : G.getVertices()) {
			if(marked.containsKey(v) == false || marked.get(v) == false) {
				dfs(G, v);
			}
		}
	}
	
	private void dfs(Graph<T> G, T v) {
		marked.put(v, true);
		for(Edge<T> e : G.adj(v)) {
			T w = e.other(v);
			if(marked.containsKey(w) == false || marked.get(w) == false) {
				dfs(G, w);
			}
		}
		order.push(v);
	}
	
	public Stack<T> getOrder(){
		return order;
	}
}