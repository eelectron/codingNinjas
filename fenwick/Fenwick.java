package fenwick;

public class Fenwick {
	long[] bit;
	public Fenwick(int n) {
		bit = new long[n + 1];
	}
	
	public void update(int idx, long v) {
		while(idx < bit.length) {
			bit[idx] += v;
			idx += (idx & -idx);
		}
	}
	
	public long query(int idx) {
		long sum = 0;
		while(idx > 0) {
			sum += bit[idx];
			idx -= (idx & -idx);
		}
		return sum;
	}
}
