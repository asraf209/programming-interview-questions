package datastructures.timetravelmap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTimeTravel {
	
	private Map<Integer, TreeMap<Long, Integer>> mapKtoTV = new HashMap<>();
	
	/**
	 * Ideally O(1). 
	 * But since we are using TreeMap, it will be O(log m); m - size of t values for any k 
	 * @param k
	 * @param t
	 * @param v
	 */
	public void put(int k, long t, int v){
		TreeMap<Long, Integer> mapTV;		// We are using TreeMap; so that, all t values will be in sorted order
		if(mapKtoTV.containsKey(k)){		// TreeMap internally use RedBlackTree to make a balanced binary Tree
			mapTV = mapKtoTV.get(k);
			mapTV.put(t, v);
		}
		else{
			mapTV = new TreeMap<>();
			mapTV.put(t, v);
			mapKtoTV.put(k, mapTV);
		}	
	}
	
	/**
	 * O(log m); m - size of t values for any k	 
	 * @param k
	 * @param t
	 * @return
	 */
	public int get(int k, long t){
		if(mapKtoTV.containsKey(k)){
			TreeMap<Long, Integer> mapTV = mapKtoTV.get(k);
			
			if(mapTV.containsKey(t))
				return mapTV.get(t);
			else{
				long closestT = findClosestT(mapTV.keySet().toArray(new Long[mapTV.size()]), t);
				return mapTV.containsKey(closestT)? mapTV.get(closestT) : Integer.MIN_VALUE;
			}
		}
				
		return Integer.MIN_VALUE;
	}
	
	/**
	 * Using binary search approach; O(log n)
	 * @param keys: Set of all t values
	 * @param t: Target timestamp
	 * @return v: Corresponding value that was happened closest to time t 
	 */
	private long findClosestT(Long[] keys, long t){
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
		
		mapTimeTravel.put(2, 2000, 222222);
		
		mapTimeTravel.put(1, 10000, 1111111);
				
		System.out.println(mapTimeTravel.get(1, 100));
		System.out.println(mapTimeTravel.get(1, 999));
		System.out.println(mapTimeTravel.get(1, 10999));
		System.out.println(mapTimeTravel.get(2, 100));
		
		/**
		 * Output:
		 * 	11111
			11111
			1111111
			-2147483648
		 */
	}

}
