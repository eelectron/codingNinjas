package tries;

import java.util.Scanner;

public class SubXor {
	Node head = new Node();
	int BITS = 8;
	public int countXorSub(int[] A, int k){
        int n = A.length;
        int ans = 0, cx = 0;
        for(int i = 0; i < n; i++){
            cx = 0;
            for(int j = i; j < n; j++){
                cx = cx ^ A[j];
                if(cx < k){
                    ans += 1;
                }
            }
        }
        return ans;
    }
    
	/*
	 * Insert bits of x in trie .
	 * Start from most significant bit .
	 * Input must be a 32 bit integer */
	public void insert(int x) {
		Node cur = head;
		int b = 0;
		for(int i = BITS - 1; i >= 0; i--) {
			cur.leaves += 1;
			b = (x >> i) & 1;
			if(b == 0) {
				if(cur.left == null) {
					cur.left = new Node();
				}
				cur = cur.left;
			}else {
				if(cur.right == null) {
					cur.right = new Node();
				}
				cur = cur.right;
			}
		}
		cur.leaves += 1;
	}
	
	public long getCountXorLessThanK(int[] A, int k) {
		int n = A.length;
		insert(0);
		
		int px = 0;
		long ans = 0;
		Node cur = null;
		for(int i = 0; i < n; i++) {
			px = px ^ A[i];
			cur = head;
			int ba = 0, bk = 0;
			for(int j = BITS - 1; (j >= 0) && (cur != null); j--) {
				ba = (px >> j) & 1;
				bk = (k >> j) & 1;
				if(bk == 1) {		// k's current bit is 1
					if(ba == 0) {
						if(cur.left != null) {
							ans += cur.left.leaves;
						}
						cur = cur.right;
					}
					else {
						if(cur.right != null) {
							ans += cur.right.leaves;
						}
						cur = cur.left;
					}
				}
				else {				// k's current bit is 0
					if(ba == 0) {
						cur = cur.left;
					}
					else {
						cur = cur.right;		// advance cur to next node, we may get xor less than k
					}
				}
			}
			
			// insert current prefix xor in tree
			insert(px);
		}
		return ans;
	}
	
	public int countLeaves(Node root) {
		if(root == null) {
			return 0;
		}
		
		if(root.left == null && root.right == null) {
			return 1;
		}
		
		int ls = countLeaves(root.left);
		int rs = countLeaves(root.right);
		return ls + rs;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t  =0; t < T; t++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] A = new int[n];
            for(int i = 0; i < n; i++){
                A[i] = sc.nextInt();
            }
            
            SubXor m = new SubXor();
            long ans = m.getCountXorLessThanK(A, k);
            System.out.println(ans);
        }
	}
}