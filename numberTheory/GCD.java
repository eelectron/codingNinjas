package numberTheory;

public class GCD {
	public long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		
		long r = 0;
		while(a % b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return b;
	}
}