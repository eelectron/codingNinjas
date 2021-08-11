package test.numerical;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import source.numerical.PowerOfThree;

class PowerOfThreeTest {

	@Test
	void testIsPowerOfThree() {
		//fail("Not yet implemented");
		PowerOfThree pt = new PowerOfThree();
		
		assertTrue(pt.isPowerOfThree(1));
		assertFalse(pt.isPowerOfThree(2));
		assertTrue(pt.isPowerOfThree(3));
		assertFalse(pt.isPowerOfThree(4));
		assertFalse(pt.isPowerOfThree(5));
		
		assertTrue(pt.isPowerOfThree(3 * 3 * 3 * 3 * 3));   // 3 ^ 5
		assertFalse(pt.isPowerOfThree(3 * 3 * 3 * 3 * 3 * 2));
		assertTrue(pt.isPowerOfThree(3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3));  // 3 ^ 15
	}

}
