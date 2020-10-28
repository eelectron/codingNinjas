package fenwick;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;



public class KQuery {
	static class QInfo{
		int id, x, y, k;
		QInfo(int id, int x, int y, int k){
			this.id = id;
			this.x = x;
			this.y = y;
			this.k = k;
		}
		
		public String toString() {
			return id + " " + x + "-" + y + " " + k;
		}
	}
	
	int[] bit ;
	QInfo[] queries;
	HashMap<Integer, HashMap<Integer, Integer>> kMap;
	int MAXSIZE = 1000000001;
	public KQuery(Integer[] A, QInfo[] queries){
		this.queries = queries;
		
		// create map
		TreeSet<Integer> ts = new TreeSet<Integer>(Arrays.asList(A));
		HashMap<Integer, Integer> aToId = new HashMap<Integer, Integer>();
		//int[] aToId = new int[MAXSIZE];
		Iterator<Integer> itr = ts.descendingIterator();
		int i = 1;
		Integer ai;
		while(itr.hasNext()) {
			ai = itr.next();
			aToId.put(ai, i);
			i += 1;
		}
		
		// initialize bit tree with count of unique items in A
		bit = new int[ts.size() + 1];
		
		// separate query 
		kMap = new  HashMap<Integer, HashMap<Integer, Integer>>();
		HashMap<Integer, Integer> hx = null, hy = null;
		for(i = 0; i < queries.length; i++) {
			// x
			hx = kMap.get(queries[i].x - 1);
			if(hx == null) {
				hx = new HashMap<Integer, Integer>();
				kMap.put(queries[i].x - 1, hx);
			}
			hx.put(queries[i].k, 0);
			
			// y
			hy = kMap.get(queries[i].y);
			if(hy == null) {
				hy = new HashMap<Integer, Integer>();
				kMap.put(queries[i].y, hy);
			}
			hy.put(queries[i].k, 0);
		}
		
		// update kMap
		int n = A.length;
		Integer hk = null;
		HashMap<Integer, Integer> kv = null;
		for(i = 0; i < n; i++) {
			// insert in bit
			update(aToId.get(A[i]), 1);
			
			// have any query for this index
			kv = kMap.get(i + 1);
			if(kv != null) {
				for(Map.Entry<Integer, Integer> entry : kv.entrySet()) {
					hk = ts.higher(entry.getKey());
					if(hk != null) {
						entry.setValue(query(aToId.get(hk)));
					}
				}
			}
		}
		
		// find answer of queries
		for(i = 0; i < queries.length; i++) {
			greater(queries[i].x, queries[i].y, queries[i].k);
		}
	}
	
	void update(int x, int v) {
		while(x < bit.length) {
			bit[x] += v;
			x += (x & -x);
		}
	}
	
	int query(int x) {
		int count = 0;
		while(x > 0) {
			count += bit[x];
			x -= (x & -x);
		}
		return count;
	}
	
	public void greater(int x, int y, int k) {
		int cx = 0, cy = 0;
		HashMap<Integer, Integer> ks = kMap.get(x - 1);
		// x index
		cx = ks.get(k);
		
		// y index
		ks = kMap.get(y);
		cy = ks.get(k);
		System.out.println(cy - cx);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// save array items
		int n = sc.nextInt();
		Integer[] A = new Integer[n];
		for(int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		
		// save query
		int q = sc.nextInt();
		QInfo[] queries = new QInfo[q];
		int x, y, k;
		for(int i = 0; i < q; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			k = sc.nextInt();
			queries[i] = new QInfo(i, x, y, k);
		}
		
		KQuery kq = new KQuery(A, queries);
	}
}