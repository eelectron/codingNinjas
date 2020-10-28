package tries;

import java.util.HashMap;

public class SENode {
	HashMap<Character, SENode> children;
	long w;
	boolean isWord;
	SENode(){
		children = new HashMap<Character, SENode>();
		w = 0;
		isWord = false;
	}
	
	SENode(long w){
		children = new HashMap<Character, SENode>();
		this.w = w;
		isWord = false;
	}
	
	public String toString() {
		return children.toString() + " " + w + " " + isWord;
	}
}