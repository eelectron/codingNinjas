package tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
// Help Me Pradyumana!
class SBSort implements Comparator<StringBuilder>{

	@Override
	public int compare(StringBuilder a0, StringBuilder a1) {
		// TODO Auto-generated method stub
		
		return a0.toString().compareTo(a1.toString());
	}
}

public class AutoComplete {
	SENode root = new SENode();
	
	public void insert(String s) {
		int n = s.length();
		SENode cur = root, child;
		for(int i = 0; i < n; i++) {
			child = cur.children.get(s.charAt(i));
			if(child == null) {
				child = new SENode();
				cur.children.put(s.charAt(i), child);
			}
			cur = child;
		}
		cur.isWord = true;
	}
	
	public void getAllWordsStartWith(SENode node, char c, StringBuilder word, List<StringBuilder> words) {
		if(node == null) {
			return;
		}
		
		word.append(c);			// append current char
		
		if(node.isWord) {		// found a word
			words.add(new StringBuilder(word));
		}
		
		// find all word start with char "c"
		for(Map.Entry<Character, SENode> entry: node.children.entrySet()) {
			getAllWordsStartWith(entry.getValue(), entry.getKey(), word, words);
		}
		word.deleteCharAt(word.length() - 1);
	}
	
	public List<StringBuilder> getWordsStartWith(String query) {
		int n = query.length();
		List<StringBuilder> words = new ArrayList<StringBuilder>();
		
		SENode cur = root, child;
		for(int i = 0; i < n; i++) {
			child = cur.children.get(query.charAt(i));
			if(child == null) {
				return words;
			}
			cur = child;
		}
		
		// collect all words whose prefix is query string
		for(Map.Entry<Character, SENode> entry : cur.children.entrySet()) {
			StringBuilder word = new StringBuilder();;
			getAllWordsStartWith(entry.getValue(), entry.getKey(), word, words);
		}
		
		
		
		// prepend query string to each word
		for(int i = 0; i < words.size(); i++) {
			words.get(i).insert(0, query);
		}
		
		// add query to list if it is a word
		if(cur.isWord) {
			words.add(new StringBuilder(query));
		}
		
		Collections.sort(words);
		return words;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AutoComplete ac = new AutoComplete();
		
		int n = sc.nextInt();
		String word;
		for(int i = 0; i < n; i++) {
			word = sc.next();
			ac.insert(word);
		}
		
		// print all words starts with query
		int q = sc.nextInt();
		String query;
		List<StringBuilder> words;
		for(int i = 0; i < q; i++) {
			query = sc.next();
			words = ac.getWordsStartWith(query);
			if(words.isEmpty()) {
				System.out.println("No suggestions");
				ac.insert(query);
			}
			else {
				for(int j = 0; j < words.size(); j++) {
					System.out.println(words.get(j));
				}
			}
		}
	}
}