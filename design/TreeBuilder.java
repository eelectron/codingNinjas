package design;

import java.util.Stack;

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
	String op;
	Node left, right;
    public abstract int evaluate();
    // define your fields here
};

class OperandNode extends Node{
	OperandNode(String op){
		this.op = op;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public int evaluate() {
		int value = Integer.parseInt(op);
		return value;
	}
	
}

class AddNode extends Node{
	AddNode(String op){
		this.op = op;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public int evaluate() {
		int lv = left.evaluate();
		int rv = right.evaluate();
		return lv + rv;
	}
}

class SubtractNode extends Node{
	SubtractNode(String op){
		this.op = op;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public int evaluate() {
		int lv = left.evaluate();
		int rv = right.evaluate();
		return lv - rv;
	}
}

class MultiplyNode extends Node{
	MultiplyNode(String op){
		this.op = op;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public int evaluate() {
		int lv = left.evaluate();
		int rv = right.evaluate();
		return lv * rv;
	}
}

class DivideNode extends Node{
	DivideNode(String op){
		this.op = op;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public int evaluate() {
		int lv = left.evaluate();
		int rv = right.evaluate();
		return lv / rv;
	}
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postfix input 
 * and returns the expression tree representing it as a Node.
 */

public class TreeBuilder {
    Node buildTree(String[] postfix) {
    	int n = postfix.length;
    	
    	Stack<Node> ps = new Stack<>();
    	for(int i = 0; i < n; i++) {
    		if(isOp(postfix[i]) == true) {
    			Node on = createNode(postfix[i]);
    			on.right = ps.pop();
    			on.left = ps.pop();
    		}
    		else {
    			ps.push(new OperandNode(postfix[i]));
    		}
    	}
        return null;
    }
    
    private boolean isOp(String ops) {
    	char op = ops.charAt(0);
    	if(op == '+' || op == '-' || op == '*' || op == '/') {
    		return true;
    	}
    	return false;
    }
    
    private Node createNode(String op) {
    	Node opNode = null;
    	if(op.equals("+")) {
    		opNode = new AddNode(op);
    	}
    	else if(op.equals("-")) {
    		opNode = new SubtractNode(op);
    	}
    	else if(op.equals("*")) {
    		opNode = new MultiplyNode(op);
    	}
    	else {
    		opNode = new DivideNode(op);
    	}
    	return opNode;
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */