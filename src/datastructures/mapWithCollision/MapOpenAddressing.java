package datastructures.mapWithCollision;

public class MapOpenAddressing {
	private int SIZE;
	private Entry[] map;
	
	public MapOpenAddressing(int SIZE){
		this.SIZE = SIZE;
		map = new Entry[this.SIZE];
	}
	
	/**
	 * O(n); n = Size of the Map 
	 * @param key
	 * @return
	 */
	public int get(int key){
		int hash = (key % SIZE);
		if(map[hash] == null)
			return Integer.MIN_VALUE;
		
		if(map[hash].key == key)
			return map[hash].value;
		else{
			int pointer = (hash + 1) % SIZE;
			while(pointer!=hash && map[pointer]!=null){
				if(map[pointer].key==key)
					return map[pointer].value;
				pointer = (pointer + 1)%SIZE;
			}
			
			return Integer.MIN_VALUE;						
		}				
	}
	
	/**
	 * O(n); n = Size of the Map
	 * @param key
	 * @param value
	 */
	public void set(int key, int value){
		int hash = (key % SIZE);
		if(map[hash] == null)
			map[hash] = new Entry(key, value);
		
		if(map[hash].key == key)
			map[hash].value = value;
		else{
			int pointer = (hash + 1) % SIZE;
			while(pointer!=hash && map[pointer]!=null){
				if(map[pointer].key==key){
					map[pointer].value = value;
					break;
				}
				pointer = (pointer + 1)%SIZE;
			}
			
			if(map[pointer]==null)
				map[pointer] = new Entry(key, value);
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
		MapOpenAddressing map = new MapOpenAddressing(SIZE);
		
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
		System.out.println(map.get(5));		// NOT FOUND
		System.out.println(map.get(6));		// NOT FOUND
	}

}
