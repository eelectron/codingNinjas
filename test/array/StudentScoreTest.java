package test.array;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import source.array.StudentScore;

public class StudentScoreTest {
	@Test
	public void testGetBestAverageScore() {
		StudentScore ss = new StudentScore();
		
		String[][] tc1 = {{"Bobby", "2"},{"Bobby", "2"}};
		assertEquals(2, ss.getBestAverageScore(tc1));
		
		String[][] tc2 = {{"A", "-2"},{"A", "-2"},{"A", "-2"}};
		assertEquals(-2, ss.getBestAverageScore(tc2));
		
		String[][] tc3 = {{"Bobby", "2"},{"Bobby", "2"},{"Charles", "4"},{"Charles", "4"}};
		assertEquals(4, ss.getBestAverageScore(tc3));
		
		String[][] tc4 = {{"Bobby", "-2"},{"Bobby", "-2"},{"Charles", "-4"},{"Charles", "-4"}};
		assertEquals(-2, ss.getBestAverageScore(tc4));
		
		String[][] tc5 = {{"Bobby", "40"}, {"Bobby", "40"}, {"Charles", "38"}, {"Charles", "38"}, {"Bobby", "20"}, {"Bobby", "20"}};
		assertEquals(38, ss.getBestAverageScore(tc5));
		
		String[][] tc6 = {};
		assertEquals(0, ss.getBestAverageScore(tc6));
		
		String[][] tc7 = null;
		assertEquals(0, ss.getBestAverageScore(tc7));
		
		String[][] tc8 = {{"Bobby", "2"}};
		assertEquals(2, ss.getBestAverageScore(tc8));
		
		String[][] tc9 = {{"A", "1000000000"},{"A", "1000000000"}};
		assertEquals(1000000000, ss.getBestAverageScore(tc9));
		
		String[][] tc10 = {{"A", "2"},{"A", "9"},{"B", "2"}, {"B","7"}};
		assertEquals(5, ss.getBestAverageScore(tc10));
		
		String[][] tc11 = {{"A", "1"},{"A", "4"}};
		assertEquals(2, ss.getBestAverageScore(tc11));
		
		String[][] tc12 = {{"A", "-1"},{"A", "-4"}};
		assertEquals(-3, ss.getBestAverageScore(tc12));
		
		String[][] tc13 = {{}};
		assertEquals(0, ss.getBestAverageScore(tc13));
	}
}