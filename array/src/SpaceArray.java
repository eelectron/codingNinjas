package array.src;

import java.util.Arrays;
import java.util.Scanner;

public class SpaceArray {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int T       = sc.nextInt();
        for(int i  = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] A = new int[N];
            for(int j = 0; j < A.length; j++) {
                A[j] = sc.nextInt();
            }
          
            boolean res = isFirstPlayerWins(A);
            if(res) {
                System.out.println("First");
            }
            else {
                System.out.println("Second");
            }
        }
    }
    
    private static boolean isFirstPlayerWins(int[] A) {
        Arrays.sort(A);
        
        int remPlace = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > i + 1) {
                return false;
            }
            remPlace += (i + 1 - A[i]);
        }
        
        if(remPlace % 2 == 0) {
            return false;
        }
        return true;
    }
}
