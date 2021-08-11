package source.numerical;

public class PowerOfThree {
	public boolean isPowerOfThree(int n) {
		String str = Double.toString(Math.log10(n) / Math.log10(3));
		return str.matches("[\\d]*[.][0]");
	}
}