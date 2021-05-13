package matrix;

import java.util.Scanner;

public class WorthyMatrix {
    public static void main(String[] args) {
        WorthyMatrix wm = new WorthyMatrix();
        wm.readInput();
        
    }
    
    public void readInput() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            
            int[][] A = new int[N][M];
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    A[j][k] = sc.nextInt();
                }
            }
            
            long count = countKWorthy(A, K);
            System.out.println(count);
        }
    }

    private long countKWorthy(int[][] A, int K) {
        int m       = A.length;
        int n       = A[0].length;
        long[][] sum  = new long[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + A[i - 1][j - 1];
            }
        }
        
        long count = 0;
        double avg = 0, curSum = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= Math.min(i, j); k++) {
                    curSum = sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k];
                    avg = curSum / (double)(k * k);
                    if(avg >= K) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }
}
