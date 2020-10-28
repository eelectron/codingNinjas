package fenwick;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Coder{
	int id, x, y;
	Coder(int id, int x, int y){
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return id + " " + x + "-" + y;
	}
}

/*
 * Sort Coders by ai */
class CoderSortByAI implements Comparator<Coder>{
	@Override
	public int compare(Coder arg0, Coder arg1) {
		// TODO Auto-generated method stub
		if(arg0.x == arg1.x) {
			return arg0.y - arg1.y;
		}
		return arg0.x - arg1.x;
	}
}

public class CoderRating {
	long[] BIT;
	int[] rank;
	public CoderRating(Coder[] coders, int maxY) {
		BIT = new long[maxY + 1];
		
		// sort by ai
		Arrays.sort(coders, new CoderSortByAI());
		
		int n = coders.length;
		rank = new int[n];
		
		int ans = 0, i = 0;
		while(i < n) {
			// coders of same rank
			int j = i;
			while(j > 0 && j < n && coders[j].x == coders[j - 1].x && coders[j].y == coders[j - 1].y) {
				rank[coders[j].id] = rank[coders[i - 1].id];
				update(coders[j].y);
				j += 1;
			}
			
			if(i == j) {
				ans = query(coders[i].y);
				rank[coders[i].id] = ans;
				update(coders[i].y);
				i += 1;
			}
			else {
				i = j;
			}
		}
	}
	
	int query(int y) {
		int count = 0;
		while(y > 0) {
			count += BIT[y];
			y -= (y & -y);
		}
		return count;
	}
	
	void update(int y) {
		while(y < BIT.length) {
			BIT[y] += 1;
			y += (y & -y);
		}
	}
	
	/* Get the rank of i'th coder ie how many are below i'th coder
	 * */
	void printRank() {
		for(int i = 0; i < rank.length; i++) {
			System.out.println(rank[i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Coder[] coders = new Coder[n];
		int x, y, maxY = 0;
		for(int i = 0; i < n; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			maxY = Math.max(maxY, y);
			coders[i] = new Coder(i, x, y);
		}
		
		CoderRating cr = new CoderRating(coders, maxY);
		cr.printRank();
	}
}
