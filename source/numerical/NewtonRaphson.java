package source.numerical;

public class NewtonRaphson {
	public static void main(String[] args) {
		NewtonRaphson nr = new NewtonRaphson();
		double A = 25;
		double ans = nr.mySqrt(A);
		System.out.println(ans);
	}
	
	public double mySqrt(double A) {
		if(A == 0) {
			return 0;
		}
		
		double x0 = A;
		double tol = 0.0001;
		while(Math.abs(x0 * x0 - A) > tol) {
			x0 = 0.5 * (x0 + (A / x0));
		}
		return x0;
	}
}