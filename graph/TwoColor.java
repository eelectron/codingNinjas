package graph;

import java.util.HashMap;
import java.util.Map;

public class TwoColor<T extends Comparable> {
	private HashMap<T, Boolean> marked;
	private HashMap<T, Boolean> color;
	private boolean isTwoColorable = true;
	public TwoColor(Graph<T> G) {
		marked = new HashMap<T, Boolean>();
		color = new HashMap<T, Boolean>();
		for(T v : G.getVertices()) {
			if(marked.containsKey(v) == false || marked.get(v) == false) {
				color.put(v, false);
				dfs(G, v);
			}
		}
	}
	
	private void dfs(Graph<T> G, T v) {
		marked.put(v, true);
		for(Edge<T> e : G.adj(v)) {
			T w = e.other(v);
			if(marked.containsKey(w) == false || marked.get(w) == false) {
				color.put(w, !(color.get(v)));
				dfs(G, w);
			}
			else if(color.get(w) == color.get(v)) {
				isTwoColorable = false;
			}
		}
	}
	
	public boolean isBipartite() {
		return isTwoColorable;
	}
}