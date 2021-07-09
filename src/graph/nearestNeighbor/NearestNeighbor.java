package graph.nearestNeighbor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestNeighbor {
	public static String[] closestStraightCity(String[] city, String[] query, int[] x, int[] y) {
		String[] res = new String[query.length];
		Map<String, Integer> cityToIndex = new HashMap<>();		// (city, index)
		Map<Integer, List<String>> xToCity = new HashMap<>();	// (x, city)
		Map<Integer, List<String>> yToCity = new HashMap<>();	// (y, city)
		String NONE = "NONE";
		
		// Pre-processing. Populate all Maps
		for (int i=0; i<city.length; i++) {
			cityToIndex.put(city[i], i);
			
			if(!xToCity.containsKey(x[i]))	xToCity.put(x[i], new ArrayList<String>());
			xToCity.get(x[i]).add(city[i]);
			
			if(!yToCity.containsKey(y[i]))	yToCity.put(y[i], new ArrayList<String>());
			yToCity.get(y[i]).add(city[i]);
		}
		
		
		for (int i=0; i<query.length; i++) {
			if (!cityToIndex.containsKey(query[i])) {
				res[i] = NONE;
				continue;
			}
			
			int cityIndex = cityToIndex.get(query[i]);
			int cityX = x[cityIndex];
			int cityY = y[cityIndex];
			
			int minDistance = Integer.MAX_VALUE;
			String nearestCity = NONE;
			
			// Find nearest along Y
			for (String cityAlongY : xToCity.get(cityX)) {
				if (cityAlongY.equals(city[cityIndex]))	continue;
				
				int distance = Math.abs(cityY - y[cityToIndex.get(cityAlongY)]);
				if (distance == minDistance) {
					nearestCity = nearestCity.compareToIgnoreCase(cityAlongY) < 0 ? nearestCity : cityAlongY ;
				}
				else if (distance < minDistance) {
					minDistance = distance;
					nearestCity = cityAlongY;
				}
			}
			
			// Find nearest along X
			for (String cityAlongX : yToCity.get(cityY)) {
				if (cityAlongX.equals(city[cityIndex]))	continue;
				
				int distance = Math.abs(cityX - x[cityToIndex.get(cityAlongX)]);
				if (distance == minDistance) {
					nearestCity = nearestCity.compareToIgnoreCase(cityAlongX) < 0 ? nearestCity : cityAlongX ;
				}
				else if (distance < minDistance) {
					minDistance = distance;
					nearestCity = cityAlongX;
				}
			}
						
			res[i] = nearestCity;
		}
		
		return res;
	}
	
	public static void main(String args[]) {
		String[] c1 = {"c1", "c2", "c3"};	// Cities
		int[] x1 = {3, 2, 1};				// X co-ordinates
		int[] y1 = {3, 2, 3};				// Y co-ordinates
		String[] q1 = {"c1", "c2", "c3"};	// Queries
		
		for (String cityName : closestStraightCity(c1, q1, x1, y1)) {
			System.out.print(cityName + ", ");
		}
		
		System.out.println();
		
		String[] c2 = {"fastcity", "bigbanana", "xyz"};	// Cities
		int[] x2 = {23, 23, 23};						// X co-ordinates
		int[] y2 = {1, 10, 20};							// Y co-ordinates
		String[] q2 = {"fastcity", "bigbanana", "xyz"};	// Queries
		
		for (String cityName : closestStraightCity(c2, q2, x2, y2)) {
			System.out.print(cityName + ", ");
		}
		
		System.out.println();
		
		String[] c3 = {"london", "warshaw", "hackerland"};	// Cities
		int[] x3 = {1, 10, 20};								// X co-ordinates
		int[] y3 = {1, 10, 10};								// Y co-ordinates
		String[] q3 = {"london", "warshaw", "hackerland"};	// Queries
		
		for (String cityName : closestStraightCity(c3, q3, x3, y3)) {
			System.out.print(cityName + ", ");
		}
		
		System.out.println();
		
		String[] c4 = {"green", "red", "blue", "yellow", "pink"};	// Cities
		int[] x4 = {100, 200, 300, 400, 500};						// X co-ordinates
		int[] y4 = {100, 200, 300, 400, 500};						// Y co-ordinates
		String[] q4 = {"green", "red", "blue", "yellow", "pink"};	// Queries
		
		for (String cityName : closestStraightCity(c4, q4, x4, y4)) {
			System.out.print(cityName + ", ");
		}
	}
}
