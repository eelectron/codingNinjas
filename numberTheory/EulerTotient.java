package numberTheory;

public class EulerTotient {
	long[] phi;
	public EulerTotient(long n) {
		phi = new long[(int)n + 1];
		
		// init with self
		for(int i = 1; i <= n; i++) {
			phi[i] = i;
		}
		
		for(int i = 2; i <= n; i++) {
			if(phi[i] == i) {
				phi[i] = phi[i] - 1;
				
				for(int j = 2 * i; j <= n; j += i) {
					phi[j] = (phi[j] * (i - 1)) / i;
				}
			}
		}
	}
	
	public long getPhi(int n) {
		return phi[n];
	}
}
