package datastructures.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	class Node{
		int key;
		int value;
		Node prev;
		Node next;		
		
		public Node(int key, int value){
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}
	
	int capcacity;
	int count;
	Node head;
	Node tail;
	Map<Integer, Node> map;
	
	public LRUCache(int capacity){
		this.capcacity = capacity;
		this.count = 0;
		this.head = null;
		this.tail = null;
		map = new HashMap<>();
	}
	
	private boolean isEmpty()	{return this.count == 0; }
	private boolean isFull()		{return this.count == this.capcacity; }
	
	private void moveToHead(Node node){
		if(node == null || count < 2)	return;		
		
		node.prev.next = node.next;				
		if(node == tail)
			tail = node.prev;		
		else
			node.next.prev = node.prev;
		
		node.next = head;
		head.prev = node;
		
		head = node;
	}
	
	
	public int get(int key){
		if(map.containsKey(key)){
			Node node = map.get(key);
			moveToHead(node);
			return node.value;
		}
		return -1;
	}	
	
	private void removeFromTail(){
		if(isEmpty())	return;
		tail = tail.prev;
		if(tail == null)
			head = tail;
		else
			tail.next = null;
		count --;
	}
	
	private void addToHead(Node node){
		if(isEmpty()){
			head = node;
			tail = head;
		}
		else{
			node.next = head;
			head.prev = node;
			head = node;
		}
		count ++;
	}
	
	public void set(int key, int value){
		if(map.containsKey(key)){
			Node node = map.get(key);
			node.value = value;
			moveToHead(node);
		}
		else{
			if(isFull())
				removeFromTail();			
			Node node = new Node(key, value);			
			addToHead(node);			
		}
	}
	
	@Override
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("Capacity: " + capcacity + "\n");
		buffer.append("Count: " + count + "\n");
		Node n = head;
		while(n!=null){
			buffer.append("(" + n.key + ", " + n.value + ") ");
			n = n.next;
		}
		buffer.append("\n");
		return buffer.toString();
	}
	
	public static void main(String[] args) {		

	}

}
