package string.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import string.src.Pangram;

public class PangramTest {
    @Test
    public void testGetAllMissingCharacter() {
        Pangram pg = new Pangram();
        assertEquals("Expected \"z\" as output", "z", pg.getAllMissingCharacter("abcdefghijklmnopqrstuvwxy"));
        assertEquals("Expected \"abcdfgijkmnpqrstuvwxyz\" ", "abcdfgijkmnpqrstuvwxyz", pg.getAllMissingCharacter("hello"));
        assertEquals("Expected empty string", "", pg.getAllMissingCharacter("abcdefghijklmnopqrstuvwxyz"));
        assertEquals("Expected all letters", "abcdefghijklmnopqrstuvwxyz", pg.getAllMissingCharacter(""));
        assertEquals("abdhijnpquvxyz", pg.getAllMissingCharacter("welcome to geeksforgeeks"));
        assertEquals("adglvyz", pg.getAllMissingCharacter("The quick brown fox jumps"));
        assertEquals("bdfjkpquvxyz", pg.getAllMissingCharacter(" Writing ALGorithmic tests!"));
    }
}