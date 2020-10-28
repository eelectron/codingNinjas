package fenwick;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Query{
	int id, x, y;
	Query(int id, int x, int y){
		this.id = id;
		this.x = x;
		this.y = y;
	}
}

class SortByY implements Comparator<Query>{
	public int compare(Query q1, Query q2) {
		return q1.y - q2.y;
	}
}

public class DistinctQuery {
	int[] BIT;
	int[] qa;
	int MAXSIZE = 1000001;
	public DistinctQuery(int[] A, Query[] queries) {
		int n = A.length;
		BIT = new int[n + 1];
		int qn = queries.length;
		qa = new int[qn];
		
		// sort query by end index
		Arrays.sort(queries, new SortByY());
		
		int[] last = new int[MAXSIZE];
		Arrays.fill(last, -1);
		
		// query answer
		int qi = 0, total = 0;
		for(int i = 0; i < n; i++) {
			if(last[A[i]] == -1) {
				total += 1;	
			}
			else {
				update(last[A[i]] + 1, -1);
			}
			
			last[A[i]] = i;
			update(i + 1, 1);
			
			// have query
			while(qi < qn && queries[qi].y == i + 1) {
				qa[queries[qi].id] = total - query(queries[qi].x - 1);
				qi += 1;
			}
		}
	}
	
	void update(int x, int v) {
		while(x < BIT.length) {
			BIT[x] += v;
			x += (x & -x);
		}
	}
	
	int query(int x) {
		int count = 0;
		while(x > 0) {
			count += BIT[x];
			x -= (x & -x);
		}
		return count;
	}
	
	public void printQuery() {
		for(int i = 0; i < qa.length; i++) {
			System.out.println(qa[i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		int[] A = new int[n];
		
		for(int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		
		int q = sc.nextInt();
		Query[] queries = new Query[q];
		int x, y;
		for(int i = 0; i < q; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			queries[i] = new Query(i, x, y);
		}
		
		DistinctQuery dq = new DistinctQuery(A, queries);
		dq.printQuery();
	}
}