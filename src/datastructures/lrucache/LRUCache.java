package datastructures.lrucache;

public class LRUCache {
	class Node{
		int key;
		int value;
		public Node(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
	
	int capcacity;
	int count;
	Node head;
	Node tail;
	
	public LRUCache(int capacity){
		this.capcacity = capacity;
		this.count = 0;
		this.head = null;
		this.tail = null;
	}
	
	public boolean isEmpty()	{return this.count == 0; }
	public boolean isFull()		{return this.count == this.capcacity; }
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
