package multithreading.src;

import java.util.Arrays;
import java.util.List;

public class ZeroEvenOddDriver {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(0,3,2,1,4,0,5,6,0,6);
		ZeroEvenOdd zeo = new ZeroEvenOdd(nums);
		Job1 j1 = new Job1(zeo);
		Job2 j2 = new Job2(zeo);
		Job3 j3 = new Job3(zeo);
		
		Thread t1 = new Thread(j1);
		Thread t2 = new Thread(j2);
		Thread t3 = new Thread(j3);
		
		t1.start();
		t2.start();
		t3.start();
	}
}