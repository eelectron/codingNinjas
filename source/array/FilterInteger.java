package source.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterInteger {
	public List<List<String>> filterInteger(List<String> input){
		List<String> integers = new ArrayList<>();
		List<String> chars = new ArrayList<>();
		
		int n = input.size();
		String item = "";
		for(int i = 0; i < n; i++) {
			item = input.get(i);
			try {
				Long.parseLong(item);
				integers.add(item);
			}
			catch(Exception ex){
				chars.add(item);
			}
		}
		
		Collections.sort(integers);
		List<List<String>> res = new ArrayList<>();
		res.add(integers);
		res.add(chars);
		return res;
	}
}
