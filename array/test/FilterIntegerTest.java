package array.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import array.src.FilterInteger;

public class FilterIntegerTest {
	@Test
	public void filterInteger() {
		FilterInteger fi = new FilterInteger();
		// "1","-2","99","a","0a","-1","-1"
		List<List<String>> res = new ArrayList<>();
		res.add(Arrays.asList("-1", "-1", "-2", "1", "99"));
		res.add(Arrays.asList("a", "0a"));
		
		List<String> input = Arrays.asList("1","-2","99","a","0a","-1","-1");
		assertEquals(res, fi.filterInteger(input));
	}
}
