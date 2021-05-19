package design;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/submissions/detail/495189121/
 * */
public class LRUCache {
    private int capacity;
    private int size;
    Map<Integer, Node> keyMap;
    DoublyLinkedList dll;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        keyMap = new HashMap<>();
        dll = new DoublyLinkedList();
    }
    
    /*
     * T : O(1)*/
    public int get(int key) {
        if(keyMap.containsKey(key) == false){
            return -1;
        }
        
        // get the key value and make it most recent
        Node curNode    = keyMap.get(key);
        LRUNode lruNode = curNode.lruNode;
        int value = lruNode.value;
        dll.shiftToLast(curNode);
        return value;
    }
    
    /*
     * T : O(1)*/
    public void put(int key, int value) {
        if(keyMap.containsKey(key) == true){
            Node curNode = keyMap.get(key);
            LRUNode lruNode = curNode.lruNode;
            lruNode.value = value;
            dll.shiftToLast(curNode);
        }
        else{
            // got a new key 
            if(size < capacity){
                Node curNode = dll.addLast(key, value);
                keyMap.put(key, curNode);
                size += 1;
            }
            else{   // cache is full evict least recently used value and add cur node
                Node remNode = dll.removeFirst();
                keyMap.remove(remNode.lruNode.key);
                
                // add new node
                Node newNode = dll.addLast(key, value);
                keyMap.put(newNode.lruNode.key, newNode);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class LRUNode{
    int key, value;
    LRUNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class Node{
    LRUNode lruNode;
    Node prev, next;
    Node(){
        lruNode = null;
        prev = null;
        next = null;
    }
}

/*
Head has least recently used node and tail
has most recently use node
*/
class DoublyLinkedList{
    Node head, tail;
    DoublyLinkedList(){
        head = new Node();    // dummy node
        tail = new Node();    // dummy node
        
        head.next = tail;
        tail.prev = head;
    }
    
    public Node addLast(int key, int value){
        LRUNode lNode = new LRUNode(key, value);
        Node node = new Node();
        node.lruNode = lNode;
        
        node.prev = tail.prev;
        node.next = tail;
        
        node.next.prev = node;
        node.prev.next = node;
        return node;
    }
    
    public Node removeFirst(){
        if(head.next == tail){
            return null;
        }
        
        Node remNode = head.next;
        head.next = remNode.next;
        remNode.next.prev = head;
        return remNode;
    }
    
    /*
    shift the given node towards the end of list
    */
    public Node shiftToLast(Node node){
        // unlink
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        // shift
        node.next = tail;
        node.prev = tail.prev;
        node.prev.next = node;
        node.next.prev = node;
        return node;
    }
}