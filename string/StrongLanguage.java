package string;

import java.util.Scanner;

public class StrongLanguage {
    public static void main(String[] args) {
        StrongLanguage sl = new StrongLanguage();
        sl.readInput();
    }
    
    public void readInput() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0 ; i < T; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            String s = sc.next();
            
            boolean res = isStrong(s, K);
            if(res) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }

    private boolean isStrong(String s, int k) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*') {
                count += 1;
            }
            else {
                count = 0;
            }
            
            if(count == k) {
                return true;
            }
        }
        return false;
    }
}
