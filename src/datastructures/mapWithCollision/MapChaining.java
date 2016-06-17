package datastructures.mapWithCollision;

import java.util.Arrays;

public class MapChaining {
	
	private int SIZE;
	private Entry[] map;
	
	public MapChaining(int SIZE){
		this.SIZE = SIZE;
		map = new Entry[this.SIZE];
	}
	
	public int get(int key){
		int hash = (key % SIZE);
		if(map[hash] == null)
			return Integer.MIN_VALUE;
		
		Entry head = map[hash];
		while(head != null){
			if(head.key == key)
				return head.value;
			head = head.next;
		}
		
		return Integer.MIN_VALUE;
	}
	
	public void set(int key, int value){
		int hash = (key % SIZE);
		if(map[hash] == null)
			map[hash] = new Entry(key, value);		
		else{
			Entry head = map[hash];
			while(head.next != null){
				if(head.key == key){
					head.value = value;
					return;
				}
				head = head.next;
			}
			
			head.next = new Entry(key, value);
		}
	}	
	
	
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for(Entry entry : map)
			buffer.append(entry);
		return buffer.toString();
	}

	public static void main(String[] args) {
		int SIZE = 10;
		MapChaining map = new MapChaining(SIZE);
		
		map.set(1, 100);
		map.set(2, 200);
		map.set(3, 300);
		map.set(1, 1000);
		System.out.println(map);
	}

}
