package problem;
import java.util.Scanner;

public class ConnectingDots {
	boolean hasCycle(String[] B, int x, int y, int sx, int sy, int k, boolean[][] v) {
		if (x < 0 || x >= B.length || y < 0 || y >= B[x].length()
				|| B[x].charAt(y) != B[sx].charAt(sy)) {
			return false;
		}

		if (x == sx && y == sy && k >= 4) {
			return true;
		}
		
		if(v[x][y] == true) {
			return false;
		}

		v[x][y] = true;
		boolean a1 = hasCycle(B, x - 1, y, sx, sy, k + 1, v);
		if (a1 == true) {
			return true;
		}

		boolean a2 = hasCycle(B, x + 1, y, sx, sy, k + 1, v);
		if (a2 == true) {
			return true;
		}

		boolean a3 = hasCycle(B, x, y - 1, sx, sy, k + 1, v);
		if (a3 == true) {
			return true;
		}

		boolean a4 = hasCycle(B, x, y + 1, sx, sy, k + 1, v);
		if (a4 == true) {
			return true;
		}

		v[x][y] = false;
		return false;
	}

	int solve(String[] B, int m, int n) {
		boolean[][] v = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean ans = hasCycle(B, i, j, i, j, 0, v);
				if (ans == true) {
					return 1;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N, M, i;
		N = scan.nextInt();
		M = scan.nextInt();
		
		String[] board = new String[N];
		for (i = 0; i < N; i++) {
			board[i] = scan.next();
		}
		
		ConnectingDots cd = new ConnectingDots();
		System.out.println(cd.solve(board, N, M));
	}
}
