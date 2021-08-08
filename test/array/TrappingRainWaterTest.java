package test.array;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import source.array.TrappingRainWater;

class TrappingRainWaterTest {

	@Test
	void testTrap() {
		//fail("Not yet implemented");
		TrappingRainWater tr = new TrappingRainWater();
		
		int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
		assertEquals(6, tr.trap(h));
		
		h = new int[]{};
		assertEquals(0, tr.trap(h));
		
		h = new int[]{0};
		assertEquals(0, tr.trap(h));
		
		h = new int[]{100};
		assertEquals(0, tr.trap(h));
		
		h = new int[]{4,4};
		assertEquals(0, tr.trap(h));
		
		h = new int[]{1,0,0,1};
		assertEquals(2, tr.trap(h));
		
		h = new int[]{4,1,1,4};
		assertEquals(6, tr.trap(h));
		
		h = new int[]{4,1,2,4};
		assertEquals(5, tr.trap(h));
		
		h = new int[]{1,2,3,4};
		assertEquals(0, tr.trap(h));
		
		h = new int[]{2,4,5,1,2,3,5,4,2};
		assertEquals(9, tr.trap(h));
	}
}