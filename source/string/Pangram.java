package source.string;

import static org.junit.Assert.assertEquals;

/*
Question # 11
Missing characters to make a string Pangram 

Pangram is a sentence containing every letter in the English alphabet. 
Given a string, find all characters that are missing from the string, i.e.,
the characters that can make the string a Pangram. We need to print output in alphabetic order.

Input : welcome to geeksforgeeks
Output : abdhijnpquvxyz

Input : The quick brown fox jumps
Output : adglvyz/*

Input : " Writing ALGorithmic tests!""

*/
public class Pangram {
    public String getAllMissingCharacter(String sentence) {
        if(sentence == null) {
            return null;
        }
        
        int n = sentence.length();
        boolean[] letters = new boolean[26];
        int curChar = -1;
        
        // mark all characters in sentence
        for(int i = 0; i < n; i++) {
            curChar = Character.toLowerCase(sentence.charAt(i)) - 'a';
            if(curChar >= 0 && curChar <= 25) {
                letters[curChar] = true;
            }
        }
        
        // collect all missing char
        String res = "";
        for(int i = 0; i < letters.length; i++) {
            if(letters[i] == false) {
                res += (char)('a' + i);
            } 
        }
        return res;
    }
    
    public static void main(String[] args) {
    	Pangram pg = new Pangram();
    	pg.testGetAllMissingCharacter();
	}
    
    public void testGetAllMissingCharacter() {
        Pangram pg = new Pangram();
        assertEquals("Expected \"z\" as output", "z", pg.getAllMissingCharacter("abcdefghijklmnopqrstuvwxy"));
        assertEquals("Expected \"abcdfgijkmnpqrstuvwxyz\" ", "abcdfgijkmnpqrstuvwxyz", pg.getAllMissingCharacter("hello"));
        assertEquals("Expected empty string", "", pg.getAllMissingCharacter("abcdefghijklmnopqrstuvwxyz"));
        assertEquals("Expected all letters", "abcdefghijklmnopqrstuvwxyz", pg.getAllMissingCharacter(""));
        assertEquals("abdhijnpquvxyz", pg.getAllMissingCharacter("welcome to geeksforgeeks"));
        assertEquals("adglvyz", pg.getAllMissingCharacter("The quick brown fox jumps"));
        assertEquals("bdfjkpquvxyz", pg.getAllMissingCharacter(" Writing ALGorithmic tests!"));
        System.out.println("All tests passed !");
    }
}