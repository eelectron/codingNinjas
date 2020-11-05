package numberTheory;
import java.util.Scanner;

public class Income {
	public long getIncome(long f0, long f1, long n) {
		
		long ans = 0;
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Income inc = new Income();
		int T = sc.nextInt();
		
		int f0, f1, n;
		for(int i = 0; i < T; i++) {
			f0 = sc.nextInt();
			f1 = sc.nextInt();
			n = sc.nextInt();
			System.out.println(inc.getIncome(f0, f1, n));
		}
	}
}