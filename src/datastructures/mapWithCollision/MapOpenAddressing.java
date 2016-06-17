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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
