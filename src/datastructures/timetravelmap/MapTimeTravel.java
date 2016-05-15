package datastructures.timetravelmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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
	
	public int get(int k, long t){
		if(mapKtoTV.containsKey(k)){
			TreeMap<Long, Integer> mapTV = mapKtoTV.get(k);
			
			if(mapTV.containsKey(t))
				return mapTV.get(t);
			else{
				long closestT = findClosestT(mapTV.keySet().toArray(new Long[mapTV.size()]), t);
				System.out.println(closestT);
				return mapTV.containsKey(closestT)? mapTV.get(closestT) : Integer.MIN_VALUE;
			}
		}
				
		return Integer.MIN_VALUE;
	}
	
	private long findClosestT(Long[] keys, long t){
		System.out.println(keys[0] + ", " + keys[keys.length-1]);
		if(keys==null || keys.length<1)
			return -1;
		
		int s=0, e=keys.length-1;
		while(s<e){
			if((s+1==e) && (t>keys[s]) && (t<keys[e]))	
				return s;
			
			int mid = (s+e)/2;			
			if(t < keys[mid])	e = mid - 1;
			else s = mid + 1;
		}
	
		if(keys[s]<t)	return keys[s];
		else if((s-1)>=0)	return keys[s-1];
		
		return -1;
	}
	
	@Override
	public String toString() {
		return "MapTimeTravel [mapKtoTV=" + mapKtoTV + "]";
	}	
	
	public static void main(String[] args) {
		MapTimeTravel mapTimeTravel = new MapTimeTravel();
		mapTimeTravel.put(1, 1000, 111);
		mapTimeTravel.put(1, 100, 11111);
		mapTimeTravel.put(1, 10000000, 11111111);
		mapTimeTravel.put(2, 20, 222);
		mapTimeTravel.put(2, 200, 22222);
		System.out.println(mapTimeTravel);
		
		System.out.println(mapTimeTravel.get(1, 1001));
	}

}
