package source.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * 5 threads calling this function
 * */
public class GoodMusic implements GoodMusicIntf {
	public synchronized int minimumRemoval(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		
		if(isValid(s) == false) {
			throw new IllegalArgumentException("Please give valid input : " + s);
		}
		// critical section start
		int n = s.length();
		Map<Character, Integer> freq = new HashMap<>();
		
		// count frequency of each character
		char ch = ' ';
		for(int i = 0; i < n; i++) {
			ch = s.charAt(i);
			freq.put(ch, freq.getOrDefault(ch, 0) + 1);
		}
		
		// t1 t2 t3 t4
		// get max freq
		int maxFreq = Collections.max(freq.values());
		int[] A = new int[maxFreq + 1];
		
		// A[i] = count of characters who are having i freq
		
		// get the count of colliding frequency
		int count = 0;
		for(Map.Entry<Character, Integer> entry : freq.entrySet()) {
			count = entry.getValue();
			A[count] += 1;
		}
		
		/*
		 * 
		 * 
		freq.values().stream().function(x){
			//A[x] += 1;
		}
		
		Solution1 - mine 
		Solution2 - other , with better design but have minor bug
		*/
		
		int res = 0, rem = 0;
		for(int i = A.length - 1; i >= 1; i--) {
			rem = A[i] - 1;
			if(rem > 0) {
				res += rem;
				A[i - 1] += rem;
			}
		}
		
		if(A[0] > 1) {
			throw new IllegalArgumentException("Please give valid input : " + s);
		}
		return res;
	}

	private boolean isValid(String s) {
		// TODO Auto-generated method stub
		if(s == null) {
			return false;
		}
		
		
		return true;
	}
}
