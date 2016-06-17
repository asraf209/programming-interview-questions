package datastructures.mapWithCollision;

public class MapOpenAddressing {
	private int SIZE;
	private Entry[] map;
	
	public MapOpenAddressing(int SIZE){
		this.SIZE = SIZE;
		map = new Entry[this.SIZE];
	}
	
	public int get(int key){
		int hash = (key % SIZE);
		if(map[hash] == null)
			return Integer.MIN_VALUE;
		
		if(map[hash].key == key)
			return map[hash].value;
		else{
			int pointer = (hash + 1) % SIZE;
			while(pointer!=hash && map[pointer].key!=key){
				pointer = (pointer + 1)%SIZE;
			}
			
			if(pointer==hash)	return Integer.MIN_VALUE;			
			return map[pointer].value;
		}				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
