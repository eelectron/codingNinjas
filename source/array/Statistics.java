package source.array;

import java.util.List;

public class Statistics {
	public int difference_calculator(List<Integer> A) {
		int n = A.size();
		
		int stat1 = getStat1(A);
		int stat2 = getStat2(A);
		int res = Math.abs(stat1 - stat2);
		return res;
	}
	
	private int getStat1(List<Integer> A) {
		int n = A.size();
		int res = 0;
		
		int count = 0;
		int start = A.get(0);
		for(int i = 0; i < n; i++) {
			if(A.get(i) == start) {
				count += 1;
			}
			else {
				if(start == count) {
					res += 1;
				}
				
				start = A.get(i);
				count = 1;
			}
		}
		
		if(start == count) {
			res += 1;
		}
		return res;
	}
	
	private int getStat2(List<Integer> A) {
		int n = A.size();
		int res = 0;
		boolean seqStart = false;
		
		int start = 0;
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(seqStart == false) {
				if(i + 1 == A.get(i)) {
					seqStart = true;
					start = A.get(i);
				}
			}
			
			if(seqStart && A.get(i) == start) {
				count += 1;
				if(i + 1 == n || A.get(i) != A.get(i + 1)) {
					if(start == count) {
						res += 1;
					}
					seqStart = false;
				}
			}
		}
		return res;
	}
}