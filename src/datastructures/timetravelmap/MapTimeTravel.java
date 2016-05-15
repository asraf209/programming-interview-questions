package datastructures.timetravelmap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTimeTravel {
	
	private Map<Integer, TreeMap<Long, Integer>> mapKtoTV = new HashMap<>();
	
	public void put(int k, long t, int v){
		TreeMap<Long, Integer> mapTV;		
		if(mapKtoTV.containsKey(k)){
			mapTV = mapKtoTV.get(k);
			mapTV.put(t, v);
		}
		else{
			mapTV = new TreeMap<>();
			mapTV.put(t, v);
			mapKtoTV.put(k, mapTV);
		}	
	}
	
	
	public static void main(String[] args) {
		
	}

}
