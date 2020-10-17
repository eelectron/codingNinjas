package graph;

public class Vertex implements Comparable<Vertex>{
	public int x, y;
	public Vertex(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// compare vertex on x
	public int compareTo(Vertex other) {
		if(x < other.x) return -1;
		if(x > other.x) return 1;
		return 0;
	}
	
	public boolean equals(Object other) {
		if(this == other) {
			return true;
		}
		
		if(other == null) {
			return false;
		}
		
		if(other instanceof Vertex == false) {
			return false;
		}
		
		Vertex v = (Vertex)other;
		if(x == v.x && y == v.y) {
			return true;
		}
		return false;
	}
	
	public int hashCode() {
		return x * 10 + y;
	}
	
	public String toString() {
		return String.format("%d %d", x, y);
	}
}
