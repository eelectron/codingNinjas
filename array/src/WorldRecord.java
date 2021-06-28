package array.src;

import java.util.Scanner;

public class WorldRecord {
    public static void main(String[] args) {
        WorldRecord wr = new WorldRecord();
        wr.readInput();
    }
    
    public void readInput() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0 ; i < T; i++) {
            double k1 = sc.nextDouble();
            double k2 = sc.nextDouble();
            double k3 = sc.nextDouble();
            double v = sc.nextDouble();
            
            boolean res = isChefBreaksRec(k1, k2, k3, v);
            if(res) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }

    private boolean isChefBreaksRec(double k1, double k2, double k3, double v) {
        double finalSpeed = k1 * k2 * k3 * v;
        double time = 100.0 / finalSpeed;
        time = Math.round(time * 100) / 100.0;
        return time < 9.58;
    }
}
