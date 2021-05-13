package dpBitMasking;

import java.util.Scanner;

public class InterestingXOR {
	public static void main(String[] args) {
		Scanner sc        = new Scanner(System.in);
		InterestingXOR ix = new InterestingXOR();
		
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int x = sc.nextInt();
			long ans = ix.getMaxProduct(x);
			System.out.println(ans);
		}
	}
	
	private long getMaxProduct(int x) {
		String sx = Integer.toBinaryString(x);
		StringBuilder A = new StringBuilder();
		StringBuilder B = new StringBuilder();
		boolean first = true;
		for(int i = 0; i < sx.length(); i++) {
		    if(sx.charAt(i) == '0') {
		        A.append('1');
		        B.append('1');
		    }
		    else {
		        if(first == true) {
		            A.append('1');
		            B.append('0');
		            first = false;
		        }
		        else {
		            A.append('0');
                    B.append('1');
		        }
		    }
		}
		
		long ai = Long.valueOf(A.toString(), 2);
		long bi = Long.valueOf(B.toString(), 2);
		long res = ai * bi;
		return res;
	}
}