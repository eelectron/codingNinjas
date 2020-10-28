package fenwick;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class QInfo{
	char c;
	int x;
	QInfo(char c, int x){
		this.c = c;
		this.x = x;
	}
	
	public String toString() {
		return c + " " + x;
	}
}

public class OrderSet {
	static int MAXSIZE = 1000000000;
	int[] bit;
	
	public OrderSet(int n) {
		bit = new int[n + 1];
	}
	
	public boolean insert(int x) {
		update(x, 1);
		return true;
	}
	
	public boolean delete(int x) {
		update(x, -1);
		return true;
	}
	
	/*
	 * Return k th smallest item from set */
	public Integer kthSmallest(int k) {
		if(k < 1) {
			return null;
		}
		
		int lo = 1, hi  = bit.length, m, count = 0;
		while(lo < hi) {
			m = lo + (hi - lo) / 2;
			count = query(m);
			if(count >= k) {
				hi = m;
			}
			else {
				lo = m + 1;
			}
		}
		return lo;
	}
	
	/*
	 * Return number of item smaller than x */
	public int count(int x) {
		int count = 0;
		count = query(x);
		return count;
	}
	
	private void update(int x, int v) {
		while(x < bit.length) {
			bit[x] += v;
			x += (x & -x);
		}
	}
	
	/*Return count of items <= x */
	private int query(int x) {
		int count = 0;
		while(x > 0) {
			count += bit[x];
			x -= (x & -x);
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int q = sc.nextInt();
		
		// save all query
		QInfo[] qi = new QInfo[q];
		char c;
		int x;
		for(int i = 0; i < q; i++) {
			c = sc.next().charAt(0);
			x = sc.nextInt();
			qi[i] = new QInfo(c, x);
		}
		
		// sort all items inserted in set
		TreeSet<Integer> is = new TreeSet<Integer>();
		for(int i = 0; i < q; i++) {
			if(qi[i].c == 'I') {
				is.add(qi[i].x);
			}
		}
		
		// create item map
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> idToX = new HashMap<Integer, Integer>();
		int j = 1;
		for(Integer ix : is) {
			map.put(ix, j);
			idToX.put(j, ix);
			j += 1;
		}
		
		// save inserted item in set
		TreeSet<Integer> ps = new TreeSet<Integer>();
		
		OrderSet os = new OrderSet(is.size());
		// process query
		for(int i = 0; i < q; i++) {
			c = (char)qi[i].c;
			x = qi[i].x;
			if(c == 'I') {
				if(ps.contains(x) == false) {
					os.insert(map.get(x));
					ps.add(x);
				}
			}
			else if(c == 'D') {
				if(ps.contains(x)) {
					os.delete(map.get(x));
					ps.remove(x);
				}
			}
			else if(c == 'C') {
				Integer ix = ps.lower(x);
				if(ix == null) {
					System.out.println(0);
				}
				else {
					System.out.println(os.count(map.get(ix)));
				}
			}
			else {
				if(x > ps.size() || x < 1) {
					System.out.println("invalid");
				}
				else {
					Integer ans = os.kthSmallest(x);
					ans = idToX.get(ans);
					System.out.println(ans);
				}
			}
		}
	}
}