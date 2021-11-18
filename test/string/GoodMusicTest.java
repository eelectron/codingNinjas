package test.string;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import source.string.GoodMusic;

public class GoodMusicTest {
	@Test
	public void minimumRemovalTest() {
		GoodMusic gm = new GoodMusic();
		
		assertEquals(0, gm.minimumRemoval(null));
		assertEquals(0, gm.minimumRemoval(""));
		assertEquals(0, gm.minimumRemoval("a"));
		assertEquals(2, gm.minimumRemoval("abbcc"));
		assertEquals(2, gm.minimumRemoval("aaabbbcc"));
		assertEquals(3, gm.minimumRemoval("abcabc"));
		assertEquals(2, gm.minimumRemoval("bbcebab"));
		assertEquals(0, gm.minimumRemoval("aaa"));
		assertEquals(0, gm.minimumRemoval("abbccc"));
		assertEquals(5, gm.minimumRemoval("aabbccdd"));
		assertEquals(6, gm.minimumRemoval("aaabbbcccddd"));
		assertEquals(9, gm.minimumRemoval("aaabbbeeecccccdddddkkkkk"));
		
		assertEquals(1, gm.minimumRemoval("aabbcccc"));
		assertEquals(3, gm.minimumRemoval("abcd"));  // a
	}
}
