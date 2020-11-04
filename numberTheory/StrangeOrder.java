package numberTheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StrangeOrder {
	public StrangeOrder() {
		
	}
	
	public void order(int n) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		boolean[] mark = new boolean[n + 1];
		
		// iterate from large num to small
		for(int i = n; i >= 2; i--) {
			if(mark[i] == true) {
				continue;
			}
			
			// collect all num which have common factors with i
			HashMap<Integer, Integer> pf = primeFactors(i);
			Set<Integer> pfs = pf.keySet();
			
			ArrayList<Integer> cur = new ArrayList<Integer>();
			cur.add(i);
			// for each prime factor collect all num which have common fac with i
			for(Integer p : pf.keySet()) {
				int j = 1, x = 0;
				while(true) {
					x = i - p * j;
					if(x < 2) {
						break;
					}
					
					if(mark[x] == false) {
						cur.add(x);
						mark[x] = true;
					}
					j += 1;
				}
			}
			
			// sort cur list in decreasing order and add to ans
			Collections.sort(cur, Collections.reverseOrder());
			
			// print
			for(int j = 0; j < cur.size(); j++) {
				System.out.print(cur.get(j) + " ");
			}
		}
		
		// print 1
		System.out.println(1);
	}
	
	/*
	 * Return prime factors */
	public HashMap<Integer, Integer> primeFactors(long n){
		HashMap<Integer, Integer> pf = new HashMap<Integer, Integer>();
        
		int count = 0;
        long tn = n;
		for(int i = 2; (i * i <= tn); i++) {
			count = 0;
			while(n % i == 0) {
				count += 1;
				n /= i;
			}
			
			if(count > 0) {
				pf.put(i, count);
			}
		}
        
        if(n != 1){
            pf.put((int)n, 1);
        }
		return pf;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StrangeOrder so = new StrangeOrder();
		so.order(n);
	}
}