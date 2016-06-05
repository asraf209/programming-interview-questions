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
		if(node.next != null)
			node.next.prev = node.prev;
		else	// This is Tail
			tail = node.prev;		
		
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
