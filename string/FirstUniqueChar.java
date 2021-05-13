package string;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * 
 * The approach for this question 
 * https://sites.google.com/view/leetcodepractice/firstuniquechar
 * */
public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        int n = s.length();
        
        FirstNonUnique fu = new FirstNonUnique();
        for(int i = 0; i < n; i++){
            fu.insert(s.charAt(i), i);
            //System.out.println(fu.getFirstNonUnique());
        }
        return fu.getFirstNonUnique();
    }
}

class Node{
    int ch, id;
    Node next, prev;
    Node(int ch, int id){
        this.id = id;
        this.ch = ch;
        this.prev = null;
        this.next = null;
    }

    Node(){
        this.id = -1;
        this.ch = -1;
        this.prev = null;
        this.next = null;
    }
}

class FirstNonUnique{
    Map<Integer, Node> seen;
    Node head, tail;
    
    public FirstNonUnique(){
        seen = new HashMap<>();
        
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public void insert(int ch, int id){
        if(seen.containsKey(ch) == false){
            Node node = addNode(ch, id);
            seen.put(ch, node);
        }
        else{
            Node remNode = seen.get(ch);
            if(remNode != null){
                removeNode(remNode);
                seen.put(ch, null);
            }
        }
    }
    
    public int getFirstNonUnique(){
        if(head.next == tail){
            return -1;
        }
        return head.next.id;
    }
    
    private Node addNode(int ch, int id){
        Node nn = new Node(ch, id);
        nn.next = tail;
        nn.prev = tail.prev;
        nn.prev.next = nn;
        nn.next.prev = nn;
        return nn;
    }
    
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    } 
}