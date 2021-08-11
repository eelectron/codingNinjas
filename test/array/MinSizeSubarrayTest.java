package test.array;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import source.array.MinSizeSubarray;

class MinSizeSubarrayTest {
	MinSizeSubarray msa = new MinSizeSubarray();
	
	@Test
	void testMinSubArrayLen() {
		//fail("Not yet implemented");
		int[] t1 = new int[]{5};
		int tar1 = 1;
		assertEquals(1, msa.minSubArrayLen(tar1, t1));
		
		t1 = new int[]{5,2};
		tar1 = 6;
		assertEquals(2, msa.minSubArrayLen(tar1, t1));
		
		t1 = new int[]{1,1,1,1,2,2,2,3,3};
		tar1 = 6;
		assertEquals(2, msa.minSubArrayLen(tar1, t1));
		
		t1 = new int[]{5};
		tar1 = 9;
		assertEquals(0, msa.minSubArrayLen(tar1, t1));
		
		t1 = new int[]{1,2,3,4,5,6,7,8,9};
		tar1 = 11;
		assertEquals(2, msa.minSubArrayLen(tar1, t1));
		
		t1 = new int[]{2,2,2,2,2,4,6};
		tar1 = 9;
		assertEquals(2, msa.minSubArrayLen(tar1, t1));
		
		t1 = new int[]{2,2,2,2,2,2,2};
		tar1 = 9;
		assertEquals(5, msa.minSubArrayLen(tar1, t1));
		
		t1 = new int[]{2,2,2,2,2,4,7,10,5,6};
		tar1 = 20;
		assertEquals(3, msa.minSubArrayLen(tar1, t1));
	}
}