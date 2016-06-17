package datastructures.mapWithCollision;

public class Entry {
	int key;
	int value;
	Entry next;
	
	public Entry(int key, int value){
		this.key = key;
		this.value = value;
		this.next = null;
	}
}
