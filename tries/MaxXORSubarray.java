package tries;

import java.util.Scanner;

public class MaxXORSubarray {
	Node head = new Node();
	public void insert(int cx) {
		Node cur;		// points to cur node in tree
		cur = head;
		int b = 0;
		// insert every bit, starting from most significant bit, into the trie
		for(int j = 31; j >= 0; j--) {
			b = (cx >> j) & 1;
			if(b == 0) {
				if(cur.left == null) {
					cur.left = new Node();
				}
				cur = cur.left;
			}
			else {
				if(cur.right == null) {
					cur.right = new Node();
				}
				cur = cur.right;
			}
		}
	}
	
	public int maxXorSubarray(int[] A) {
		int n = A.length;
		if(n == 0) {
			return 0;
		}
		
		// initialize tree
		insert(0);
		
		int maxXor = 0, px = 0, cx = 0, b = 0;
		Node cur;
		for(int i = 0; i < n; i++) {
			px  = px ^ A[i];
			cur = head;
			cx = 0;
			for(int j = 31; j >= 0; j--) {
				b = (px >> j) & 1;
				if(b == 0) {
					if(cur.right != null) {
						cur = cur.right;
						cx += (1 << j);
					}
					else {
						cur = cur.left;
					}
				}else {
					if(cur.left != null) {
						cur = cur.left;
						cx += (1 << j);
					}
					else {
						cur = cur.right;
					}
				}
			}
			maxXor = Math.max(maxXor, cx);
			insert(px);
		}
		return maxXor;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for(int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		
		MaxXORSubarray mx = new MaxXORSubarray();
		int ans = mx.maxXorSubarray(A);
		System.out.println(ans);
	}
}