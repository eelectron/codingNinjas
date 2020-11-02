package numberTheory;

class Node{
	long g, x, y;
	Node(long g, long x, long y){
		this.g = g;
		this.x= x;
		this.y = y;
	}
}

public class ExtendedEuclid {
	public ExtendedEuclid() {
		
	}
	
	public Node gcd(long a, long b) {
		long x = a, y = b, c = 1, d = 0, e = 0, f = 1;
		if(b == 0) {
			return new Node(x, c, d);
		}
		
		long r = 0, q = 0, xc, yc, cc, dc, ec, fc;
		// stop when y == 0, then our gcd will be x
		while(y != 0) {
			// update x with y, and coe of x also
			xc = y;
			cc = e;
			dc = f;
			
			// update y and its coe
			r = x % y;
			q = x / y;
			
			y = r;
			e = (c - q * e);
			f = (d - q * f);
			
			x = xc;
			c = cc;
			d = dc;
		}
		return new Node(x, c, d);
	}
}
