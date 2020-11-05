package numberTheory;

public class Exponent {
	public Exponent() {
		
	}
	
	public long modExpRec(int a, int b, int c) {
		if(a == 0) {
			return 0;
		}
		
		if(b == 0) {
			return 1;
		}
		
		long ans = 0, smallAns = 0;
		if(b % 2 == 0) {
			smallAns = modExpRec(a, b / 2, c);
			ans = smallAns * smallAns;
		}
		else {
			smallAns = modExpRec(a, b / 2, c);
			ans = a % c;
			ans = (ans * smallAns) % c;
		}
		ans = (ans + c) % c;
		return ans;
	}
	
	public long modExpIt(long a, long b, long c) {
		if(a == 0) {
			return 0;
		}
		
		if(b == 0) {
			return 1;
		}
		
		long res = 1;
		while(b > 0) {
			if((b & 1) == 1) {
				res = (res * a) % c;
			}
			
			b = b >> 1;
			a = (a * a) % c;
		}
		
		res = (res + c) % c;
		return res;
	}
}