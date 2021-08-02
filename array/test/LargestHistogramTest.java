package array.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import array.src.LargestHistogram;

class LargestHistogramTest {

	@Test
	void testLargestRectangleArea() {
		//fail("Not yet implemented");
		LargestHistogram lh = new LargestHistogram();
		
		int[] a = {1};
		assertEquals(1, lh.largestRectangleArea(a));
		
		int[] b = {};
		assertEquals(0, lh.largestRectangleArea(b));
		
		int[] c = null;
		assertEquals(0, lh.largestRectangleArea(c));
		
		int[] h1 = {1,2,3,4,5};
		assertEquals(9, lh.largestRectangleArea(h1));
		
		int[] h2 = {5,4,3,2,1};
		assertEquals(9, lh.largestRectangleArea(h2));
		
		int[] h3 = {4,4,4,4,4};
		assertEquals(20, lh.largestRectangleArea(h3));
		
		int[] h4 = {1,2,3,4,5,5,4,3,2,1};
		assertEquals(18, lh.largestRectangleArea(h4));
		
		int[] h5 = {5,4,3,2,1,1,2,3,4,5};
		assertEquals(10, lh.largestRectangleArea(h5));
		
		int[] h6 = {1,2,3,4,5,5,5,5,4,3,2,1};
		assertEquals(24, lh.largestRectangleArea(h6));
	}
}