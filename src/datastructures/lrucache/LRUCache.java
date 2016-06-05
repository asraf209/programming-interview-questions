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
	
	public boolean isEmpty()	{return this.count == 0; }
	public boolean isFull()		{return this.count == this.capcacity; }
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
