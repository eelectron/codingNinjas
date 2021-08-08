package test.array;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import array.src.StudentScore;

public class StudentScoreTest {
	@Test
	public void testGetBestAverageScore() {
		StudentScore ss = new StudentScore();
		
		String[][] tc1 = {{"Bobby", "2"},{"Bobby", "2"}};
		assertEquals(2, ss.getBestAverageScore(tc1));
		
		String[][] tc2 = {};
		assertEquals(0, ss.getBestAverageScore(tc2));
		
		String[][] tc3 = {{"Bobby", "2"},{"Bobby", "2"},{"Charles", "4"},{"Charles", "4"}};
		assertEquals(4, ss.getBestAverageScore(tc3));
		
		String[][] tc4 = {{"Bobby", "-2"},{"Bobby", "-2"},{"Charles", "-4"},{"Charles", "-4"}};
		assertEquals(-2, ss.getBestAverageScore(tc4));
		
		String[][] tc5 = {{"Bobby", "40"}, {"Bobby", "40"}, {"Charles", "38"}, {"Charles", "38"}, {"Bobby", "20"}, {"Bobby", "20"}};
		assertEquals(38, ss.getBestAverageScore(tc5));
	}
}