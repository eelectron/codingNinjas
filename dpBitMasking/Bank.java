package dpBitMasking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class Node{
	long v;
	int w;
	public Node(long v, int w) {
		this.v = v;
		this.w = w;
	}
	
	public String toString() {
		return v + " " + w;
	}
}

class SortByVal implements Comparator<Node>{
	public int compare(Node a, Node b) {
		long x = a.v - b.v;
        if(x < 0){
            return -1;
        }
        else if(x > 0){
            return 1;
        }
        else{
            return 0;
        }
	}
}

public class Bank {
	Node[] items;
	int W;
	int[] primes = {1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
	public Bank(Node[] items, int W) {
		this.items = items;
		this.W = W;
	}
	
	public long maxProfit() {
		int n = items.length;
		if(n == 0) {
			return 0;
		}
		
		// sort items by value
		Arrays.sort(items, new SortByVal());
		
		long[][][] dp = new long[2][n + 1][W + 1];
		
		// use no primes
		for(int j = 0; j <= items.length; j++) {
			for(int w = 0; w <= W; w++) {
				if(j == 0 || w == 0) {
					dp[0][j][w] = 0;
				}
				else {
					long ex = dp[0][j - 1][w];
					long inc = 0;
					if(items[j - 1].w <= w) {
						inc = items[j - 1].v + dp[0][j - 1][w - items[j - 1].w];
					}
					dp[0][j][w] = Math.max(inc, ex);
				}
			}
		}
		
		for(int i = 1; i < primes.length; i++) {
			for(int j = 0; j <= items.length; j++) {
				for(int w = 0; w <= W; w++) {
					if(j == 0 || w == 0) {
						dp[1][j][w] = 0;
					}
					else {
						long ex = dp[1][j - 1][w];
						long inc = 0;
						long incWithPrime = 0;
						if(items[j - 1].w <= w) {
							inc = items[j - 1].v + dp[1][j - 1][w - items[j - 1].w];
							incWithPrime = items[j - 1].v * primes[i] + dp[0][j - 1][w - items[j - 1].w];
						}
						
						dp[1][j][w] = Math.max(incWithPrime, Math.max(inc, ex));
					}
				}
			}
			
			// copy it to prev 
			for(int j = 0; j <= items.length; j++) {
				for(int w = 0; w <= W; w++) {
					dp[0][j][w] = dp[1][j][w];
				}
			}
			
			// zero
			for(int k = 0; k <= items.length; k++) {
				Arrays.fill(dp[1][k], 0);
			}
		}
		return dp[0][n][W];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int W = sc.nextInt();
		Node[] items = new Node[n];
		
		long v;
		int w;
		for(int i = 0; i < n; i++) {
			v = sc.nextLong();
			w = sc.nextInt();
			items[i] = new Node(v, w);
		}
		
		Bank bk = new Bank(items, W);
		System.out.println(bk.maxProfit());
	}
}