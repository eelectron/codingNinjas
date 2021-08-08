package test.array;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import array.src.TrappingRainWater;

class TrappingRainWaterTest {

	@Test
	void testTrap() {
		//fail("Not yet implemented");
		TrappingRainWater tr = new TrappingRainWater();
		
		int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
		assertEquals(6, tr.trap(h));
	}
}
