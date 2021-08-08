package test.multithreading.zeroevenodd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import multithreading.zeroevenodd.src.*;

class ZeroEvenOddTest {
	@Test
	void testSingleZero() {
		//fail("Not yet implemented");
		List<Integer> nums = Arrays.asList(0);
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
		
		assertEquals(nums, zeo.getOutput());
	}
	
	@Test
	void test() {
		//fail("Not yet implemented");
		List<Integer> nums = Arrays.asList(0,3,2,1,4,0,5,6,0,0,6);
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
		
		assertEquals(nums, zeo.getOutput());		// Getting concurrent modification EXCEPTION
	}
	
	@Test
	void testOnlyOdds() {
		//fail("Not yet implemented");
		List<Integer> nums = Arrays.asList(3,1,5,5,7,9,1,1);
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
		
		assertEquals(nums, zeo.getOutput());
	}
}