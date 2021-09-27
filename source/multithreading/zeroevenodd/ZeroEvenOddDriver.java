package source.multithreading.zeroevenodd;

import java.util.Arrays;
import java.util.List;

public class ZeroEvenOddDriver {
	public static void main(String[] args) throws InterruptedException {
		List<Integer> nums = Arrays.asList(0,3,2,1,4,0,5,6,0,0,6,0,3,2,1,4,0,5,6,0,0,6,0,3,2,1,4,0,5,6,0,0,6,9);
		ZeroEvenOdd zeo = new ZeroEvenOdd(nums);
		ZeroEvenOddJob1 j1 = new ZeroEvenOddJob1(zeo);
		ZeroEvenOddJob2 j2 = new ZeroEvenOddJob2(zeo);
		ZeroEvenOddJob3 j3 = new ZeroEvenOddJob3(zeo);
		
		Thread t1 = new Thread(j1);
		Thread t2 = new Thread(j2);
		Thread t3 = new Thread(j3);
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println(zeo);
	}
}