package array.src;

import java.util.Arrays;

public class ShortestSubarray {
	public int findLengthOfShortestSubarray(int[] A) {
		int n = A.length;

		// is already sorted
		boolean isSorted = true;
		for (int i = 1; i < n; i++) {
			if (A[i] < A[i - 1]) {
				isSorted = false;
				break;
			}
		}

		if (isSorted == true) {
			return 0;
		}

		// left pass
		int lb = n - 1;
		for (int i = n - 2; i >= 0; i--) {
			if (A[i] > A[i + 1]) {
				break;
			}
			lb -= 1;
		}

		int ans = n - lb;

		// right pass
		int rb = 0, pos = 0;
		for (int i = 0; i < n; i++) {
			if (i > 0 && A[i - 1] > A[i]) {
				break;
			}
			pos = binarySearch(A, lb, n, A[i]);
			if (pos < 0) {
				pos = -(pos + 1);
			}
			ans = Math.max(ans, n - pos + i + 1);
		}
		ans = n - ans;
		return ans;
	}

	public static void main(String[] args) {
		int[] A = {16,10,0,3,22,1,14,7,1,12,15};
		ShortestSubarray ss = new ShortestSubarray();
		System.out.println(ss.findLengthOfShortestSubarray(A));
	}

	private int binarySearch(int[] A, int lb, int ub, int k) {
		int m = lb;
		while (lb < ub) {
			m = lb + (ub - lb) / 2;
			if (k <= A[m]) {
				ub = m;
			} else {
				lb = m + 1;
			}
		}
		return lb;
	}
}
