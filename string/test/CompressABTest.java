package string.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import string.src.CompressAB;

class CompressABTest {

	@Test
	void testCompress() {
		//fail("Not yet implemented");
		CompressAB cab = new CompressAB();
		
		assertEquals("", cab.compress(""));
		assertEquals("a", cab.compress("a"));
		assertEquals("ab", cab.compress("ab"));
		assertEquals("a**", cab.compress("aaaa"));
		assertEquals("a***", cab.compress("aaaaaaaa"));
		assertEquals("ab*c*d", cab.compress("ababcababcd"));
		assertEquals("ab*", cab.compress("abab"));
		assertEquals("abcba", cab.compress("abcba"));
		assertEquals("abcd", cab.compress("abcd"));
		assertEquals("a**bbbb", cab.compress("aaaabbbb"));
		assertEquals("ab*c", cab.compress("ababc"));
	}
}