package source.array;

import java.util.Scanner;

public class NoTime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int H = sc.nextInt();
		int x = sc.nextInt();
		int[] T = new int[N];
		for(int i = 0 ; i < N; i++) {
			T[i] = sc.nextInt();
		}
		
		NoTime nt = new NoTime();
		boolean res = nt.getTimeZone(x, H, T);
		if(res) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}

	private boolean getTimeZone(int x, int H, int[] T) {
		// TODO Auto-generated method stub
		for(int i = 0; i < T.length; i++) {
			if(T[i] + x >= H) {
				return true;
			}
		}
		return false;
	}
}
