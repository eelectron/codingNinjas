package tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

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
		ArrayList<String> words;
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
	
	public void getAllWordsStartWith(SENode node, char c, StringBuilder word, ArrayList<StringBuilder> words) {
		if(node == null) {
			return;
		}
		
		word.append(c);			// append current char
		
		if(node.isWord) {		// found a word
			words.add(word);
		}
		
		// find all word start with char "c"
		for(Map.Entry<Character, SENode> entry: node.children.entrySet()) {
			
		}
	}
	
	public ArrayList<String> getWordsStartWith(String query) {
		int n = query.length();
		ArrayList<String> words = new ArrayList<String>();
		
		SENode cur = root, child;
		for(int i = 0; i < n; i++) {
			
		}
		
		Collections.sort(words);
		return words;
	}
}
