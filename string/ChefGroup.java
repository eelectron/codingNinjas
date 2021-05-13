package string;

import java.util.Scanner;

public class ChefGroup {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		ChefGroup cg = new ChefGroup();
		for(int i = 0; i < T; i++) {
			String s = sc.next();
			int res = cg.getGroups(s);
			System.out.println(res);
		}
	}

	private int getGroups(String s) {
		// TODO Auto-generated method stub
		int x = 0, n = s.length();
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == '0' && s.charAt(i - 1) == '1') {
				x += 1;
			}
		}
		
		if(s.charAt(n - 1) == '1') {
			x += 1;
		}
		return x;
	}
}
