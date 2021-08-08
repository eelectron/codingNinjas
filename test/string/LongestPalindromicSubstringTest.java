package test.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import source.string.LongestPalindromicSubstring;

class LongestPalindromicSubstringTest {
	@Test
	void testLongestPalindrome() {
		//fail("Not yet implemented");
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		assertEquals("m", lps.longestPalindrome("m"));
		assertEquals("aba", lps.longestPalindrome("cabad"));
		assertEquals("aaa", lps.longestPalindrome("aaa"));
		assertEquals("", lps.longestPalindrome(""));
	}
}