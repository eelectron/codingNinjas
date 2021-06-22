package string.test;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import string.src.LongestUniformSubstring;

public class LongestUniformSubstringTest {
    @Test
    public void testLongestUniformSubstring() {
        LongestUniformSubstring lus = new LongestUniformSubstring();
        assertArrayEquals(new int[] {-1, 0}, lus.longestUniformSubstring(""));
        assertArrayEquals(new int[] {1, 4}, lus.longestUniformSubstring("10000111"));
        assertArrayEquals(new int[] {2, 5}, lus.longestUniformSubstring("aabbbbbCdAA"));
        assertArrayEquals(new int[] {2, 3}, lus.longestUniformSubstring("aakkkdddC"));
        assertArrayEquals(new int[] {0, 7}, lus.longestUniformSubstring("aaaaaaa"));
        assertArrayEquals(new int[] {0, 1}, lus.longestUniformSubstring("d"));
        assertArrayEquals(new int[] {29, 8}, lus.longestUniformSubstring("1000011010101110110100010010011111111"));
    }
}