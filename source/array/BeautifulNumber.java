package source.array;

public class BeautifulNumber {
	private static int MAX = 1000000 + 1;
	private static Boolean[] num = new Boolean[MAX];
	private static int[] ps = new int[MAX];
	public static void main(String[] args) {
		num[0] = false;
		num[1] = true;
		num[10] = true;
		num[100] = true;
		num[1000] = true;
		num[10000] = true;
		num[100000] = true;
		num[1000000] = true;
		
		num[2] = false;
		num[3] = false;
		num[4] = false;
		num[5] = false;
		num[6] = false;
		num[7] = false;
		num[8] = false;
		num[9] = false;
		
		for(int i = 0; i < MAX; i++) {
			if(num[i] == null) {
				num[i] = isBeautiful(i);
			}
		}
		
		// prefix sum
		ps[0] = 0;
		ps[1] = 1;
		for(int i = 2; i < MAX; i++) {
			if(num[i] == true) {
				ps[i] += ps[i - 1] + i;
			}
			else {
				ps[i] += ps[i - 1];
			}
		}
		
		System.out.println(solve(31, 32));
	}
	
	private static Boolean isBeautiful(int x) {
		// TODO Auto-generated method stub
		if(num[x] != null) {
			return num[x];
		}
		
		int sum = 0;
		String ns = Integer.toString(x);
		for(int i = 0; i < ns.length(); i++) {
			sum += (ns.charAt(i) - '0') * (ns.charAt(i) - '0');
		}
		num[x] = isBeautiful(sum);
		return num[x];
	}

	private static int solve(int l, int r) {
		return ps[r] - ps[l - 1];
	}
}
