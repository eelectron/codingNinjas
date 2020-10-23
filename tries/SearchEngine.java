package tries;

import java.util.Scanner;

public class SearchEngine {
	SENode root = new SENode();
	
	public void insert(String s, long w) {
		int n = s.length();
		SENode cur = root, child = null;
		for(int i = 0; i < n; i++) {
			child = cur.children.get(s.charAt(i));
			if(child == null) {
				child = new SENode(w);
				cur.children.put(s.charAt(i), child);
			}
			else {
				child.w = Math.max(child.w, w);
			}
			cur = child;
		}
	}
	
	public long query(String s) {
		int n = s.length();
		SENode cur = root, child;
		
		for(int i = 0; i < n; i++) {
			child = cur.children.get(s.charAt(i));
			if(child == null) {
				return -1;
			}
			else {
				cur = child;
			}
		}
		return cur.w;
	}
	
	public static void main(String[] args) {
		SearchEngine se = new SearchEngine();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		// insert strings
		String s;
		long w;
		for(int i = 0; i < n; i++) {
			s = sc.next();
			w = sc.nextInt();
			
			// insert in trie
			se.insert(s, w);
		}
		
		// find max of query 
		String sq;
		for(int i = 0; i < q; i++) {
			sq = sc.next();
			w = se.query(sq);
			System.out.println(w);
		}
	}
}