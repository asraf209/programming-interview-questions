package datastructures.mapWithCollision;

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
	
	public static void main(String[] args) {
		int SIZE = 10;
		MapChaining map = new MapChaining(SIZE);
		System.out.println(map.get(100));
		
	}

}
