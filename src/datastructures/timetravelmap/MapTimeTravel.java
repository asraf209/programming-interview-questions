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
	
	@Override
	public String toString() {
		return "MapTimeTravel [mapKtoTV=" + mapKtoTV + "]";
	}	
	
	public static void main(String[] args) {
		MapTimeTravel mapTimeTravel = new MapTimeTravel();
		mapTimeTravel.put(1, 10, 111);
		mapTimeTravel.put(1, 100, 11111);
		mapTimeTravel.put(2, 20, 222);
		mapTimeTravel.put(2, 200, 22222);
		System.out.println(mapTimeTravel);
	}

}
