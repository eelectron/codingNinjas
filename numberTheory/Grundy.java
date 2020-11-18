package numberTheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grundy {
	public int grundy(int n) {
		if(n == 0) {
			return 0;
		}
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(grundy(n/2));
		A.add(grundy(n/3));
		A.add(grundy(n/6));
		
		Collections.sort(A);
		int g = 0;
		for(int i = 0; i < A.size(); i++) {
			if(A.get(i) == g) {
				g += 1;
			}
		}
		return g;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Grundy gd = new Grundy();
		
		int n = sc.nextInt();
		System.out.println(gd.grundy(n));
	}
}
