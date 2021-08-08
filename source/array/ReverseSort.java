package source.array;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for(int j = 0; j < N; j++) {
                A[j] = sc.nextInt();
            }
            
            int cost = getCostOfReverse(A);
            System.out.println("Case #" + i + ": " + cost);
        }
    }

    private static int getCostOfReverse(int[] A) {
        int n = A.length;
        
        int[] minA = new int[n];
        minA[n - 1] = n - 1;
        for(int i = n - 2; i >= 0; i--) {
            int curItem = A[i];
            int minRight = A[minA[i + 1]];
            if(curItem < minRight) {
                minA[i] = i;
            }
            else {
                minA[i] = minA[i + 1];
            }
        }
        
        int cost = 0, mi = -1;
        for(int i = 0; i < n - 1; i++) {
            mi = getMinItemIndex(A, i);
            cost += (mi - i) + 1;
            reverse(A, i, mi);
        }
        return cost;
    }

    private static int getMinItemIndex(int[] A, int start) {
        int n = A.length;
        if(start >= n) {
            return n;
        }
        int mi = start, me = A[start];
        for(int i = start; i < n; i++) {
            if(A[i] < me) {
                me = A[i];
                mi = i;
            }
        }
        return mi;
    }

    private static void reverse(int[] A, int i, int j) {
        // TODO Auto-generated method stub
        while(i < j) {
            int t = A[i];
            A[i] = A[j];
            A[j] = t;
            i += 1;
            j -= 1;
        }
    }
}
