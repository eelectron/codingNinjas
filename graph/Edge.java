package graph;

public class Edge<T extends Comparable> implements Comparable<Edge>{
    T u, v;
    float w;
	public Edge(T u, T v, float w){
        this.u = u;
        this.v = v;
        this.w = w;
    }    
    
    public T either(){
        return u;
    }
    
    public T other(T vertex){
        if(u.equals( vertex)) 		return v;
        else if(v.equals(vertex))	return u;
        else throw new RuntimeException("Incosistent Edge");
    }
    
    /*
     * */
    public boolean equals(Object other) {
    	if(this == other) {
    		return true;
    	}
    	
    	if(other == null) {
    		return false;
    	}
    	
    	Edge<T> e = (Edge<T>)other;
    	if(u.compareTo(e.either()) == 0 && v.compareTo(e.other(e.either())) == 0) {
    		return true;
    	}
    	return false;
    }
    
    public int hashCode() {
    	return u.hashCode() + v.hashCode() + (int)w;
    }
    
    public int compareTo(Edge other){
        if(w < other.w)	return -1;
        if(w > other.w)	return 1;
        if(w == other.w){
            return u.compareTo(other.u);
        }
        return 0;
    }
    
    public float weight() {
    	return w;
    }
    
    public String toString(){
        return String.format("%s %s %d", u, v, (int)w);
    }
}
