package numerical.src;

public class PowerOfThree {
	public boolean isPowerOfThree(int n) {
		String str = Double.toString(Math.log10(n) / Math.log10(3));
		return str.matches("[\\d]*[.][0]");
	}
}

class Solution {

	public int trap(int[] height) { 
	int volume = 0; 
	final int length = height.length; 
	int maxHeight = 0; 
	for (int i = 0; i <= length; i++) { 
	Boolean rightBoundFound = false; 
	int rightBound = 0; 
	if(maxHeight == 0 || a[i] >= maxHeight) { 
	for (int j = i; j < length; j++) { 
	if(a[j] >= a[i]) { 
	rightBoundFound = true; 
	rightBound = j; 
	} 
	} 
	volume += a[i] * rightBound –1; 
	} 
	else{ 
	volume -= a[i] 
	} 
	} 
	if(rightBoundFound) { 
	maxHeight = rightBound; 
	} 
	return volume; 
	 
	}

}