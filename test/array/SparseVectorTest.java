package test.array;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import source.array.SparseVector;

class SparseVectorTest {
	
	@Test
	void test() {
		//fail("Not yet implemented");
		int[] a1 = new int[] {1,0,0,1};
		int[] a2 = new int[] {1,0,0,1};
		
		SparseVector sv1 = new SparseVector(a1);
		SparseVector sv2 = new SparseVector(a2);
		assertEquals(2, sv1.dotProduct(sv2));
	}
	
	@Test
	void testBig() {
		//fail("Not yet implemented");
		int[] a1 = new int[] {100,0,0,100};
		int[] a2 = new int[] {100,0,0,100};
		
		SparseVector sv1 = new SparseVector(a1);
		SparseVector sv2 = new SparseVector(a2);
		assertEquals(20000, sv1.dotProduct(sv2));
	}
	
	@Test()
	void testNullArray() {
		int[] a1 = null;
		int[] a2 = new int[] {100,0,0,100};
		
		assertThrows(IllegalArgumentException.class, 
				() ->{			
					SparseVector sv1 = new SparseVector(a1);
					SparseVector sv2 = new SparseVector(a2);
				});
	}
	
	@Test()
	void testEmptyArray() {
		int[] a1 = {};
		int[] a2 = new int[] {100,0,0,100};
		
		assertThrows(IllegalArgumentException.class, 
				() ->{			
					SparseVector sv1 = new SparseVector(a1);
					SparseVector sv2 = new SparseVector(a2);
				});
	}
	
	@Test
	void testAllSame() {
		//fail("Not yet implemented");
		int[] a1 = new int[] {1,1,1,1,1,1,1,1};
		int[] a2 = new int[] {1,1,1,1,1,1,1,1};
		
		SparseVector sv1 = new SparseVector(a1);
		SparseVector sv2 = new SparseVector(a2);
		assertEquals(8, sv1.dotProduct(sv2));
	}
}