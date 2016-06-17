package datastructures.mapWithCollision;

public class MapChaining {
	
	private int SIZE;
	private Entry[] map;
	
	public MapChaining(int SIZE){
		this.SIZE = SIZE;
		map = new Entry[this.SIZE];
	}
	
	/**
	 * O(m); m = Size of the list in a particular key during collision 
	 * @param key
	 * @return
	 */
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
	
	/**
	 * O(m); m = Size of the list in a particular key during collision
	 * @param key
	 * @param value
	 */
	public void set(int key, int value){
		int hash = (key % SIZE);
		if(map[hash] == null)
			map[hash] = new Entry(key, value);		
		else{
			Entry head = map[hash];			
			while(head != null){				
				if(head.key == key){
					head.value = value;
					break;
				}
				
				if(head.next == null){
					head.next = new Entry(key, value);
					break;
				}
				
				head = head.next;
			}
						
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
		int SIZE = 3;
		MapChaining map = new MapChaining(SIZE);
		
		map.set(1, 100);
		map.set(2, 200);
		map.set(3, 300);
		map.set(1, 1000);
		System.out.println(map);
		
		map.set(3, 3000);
		map.set(5, 5000);
		map.set(6, 6000);
		System.out.println(map);
		
		System.out.println(map.get(10));	// NOT FOUND
		System.out.println(map.get(1));		// 1000
		System.out.println(map.get(2));		// 200
		System.out.println(map.get(3));		// 3000
		System.out.println(map.get(5));		// 5000
		System.out.println(map.get(6));		// 6000
	}

}
