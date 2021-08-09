package test.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import source.string.FirstUniqueChar;

class FirstUniqueCharTest {

	@Test
	void testFirstUniqChar() {
		//fail("Not yet implemented");
		FirstUniqueChar fc = new FirstUniqueChar();
		assertEquals(-1, fc.firstUniqChar(null));
		assertEquals(-1, fc.firstUniqChar(""));
		assertEquals(0, fc.firstUniqChar("a"));
		assertEquals(-1, fc.firstUniqChar("aa"));
		assertEquals(0, fc.firstUniqChar("abcdef"));
		assertEquals(6, fc.firstUniqChar("abcabcdcqb"));
		assertEquals(10, fc.firstUniqChar("aaaaabbbbbc"));
		assertEquals(15, fc.firstUniqChar("aaaaabbbbbcccccd"));
	}
}