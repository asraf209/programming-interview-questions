package array.lockerLocations;

import java.util.ArrayList;
import java.util.List;

public class LockerLocations {
	
	/**
	 * Compute Distance form current (x, y) to the (lockerX, lockerY)
	 * Locker positions (X, Y) are in [1-9] Range. 
	 * So you have to deduct 1 from each of their values
	 */
	private static int distance(int r, int c, int[]X, int[]Y){
		int minDistance = Integer.MAX_VALUE;
		for(int i=0; i<X.length; i++){
			int distance = Math.abs(r-(Y[i]-1)) + Math.abs(c-(X[i]-1));	// Row/Column starts from 0 
			minDistance = Math.min(minDistance, distance);
		}
		return minDistance;
	}
		
	/**
	 * CityLength represents X direction
	 * CityWidth represents Y direction
	 * -- X -- 
	 * |_|_|_|  |
	 * |_|_|_|  
	 * |_|_|_|  Y
	 * |_|_|_|
	 * |_|_|_|  |
	 */
	public static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] X, int[] Y){		
		int[][] grid = new int[cityWidth][cityLength];				
		for(int r=0; r<cityWidth; r++){
			for(int c=0; c<cityLength; c++){
				grid[r][c] = distance(r, c, X, Y);
			}
		}		
		return grid;
	}
	
	/**
	 * BFS to populate the grid. We will start from all given locker position first. 
	 * Then their adjacent nodes, then their adjacent, and so on..
	 * 
	 * This is faster than the previous approach, where we were computing distance for every node.
	 */
	public static int[][] bfsGrid(int cityLength, int cityWidth, int[] X, int[] Y){		
		int[][] grid = new int[cityWidth][cityLength];				
		
		// This is to keep track of nodes, that we have already visited.
		// We can skip using it though, if all the grid nodes were initialized with -1 value.
		// So, instead of !visited[r][c] we can use grid[r][c]==-1
		boolean[][] visited = new boolean[cityWidth][cityLength];	

		List<int[]> basePoints = new ArrayList<>();
		for(int i=0; i<X.length; i++) {
			basePoints.add(new int[] {(X[i]-1), (Y[i]-1)});
			visited[X[i]-1][Y[i]-1] = true;
		}
		
		while(true) {
			List<int[]> newBasePoints = new ArrayList<>();
			for(int i=0; i<basePoints.size(); i++) {
				int r = basePoints.get(i)[0];
				int c = basePoints.get(i)[1];
				
				// Left
				if (c>0 && !visited[r][c-1]) {
					grid[r][c-1] = 1 + grid[r][c];
					visited[r][c-1] = true;
					newBasePoints.add(new int[] {r, c-1});
				}
				
				// Right
				if (c<(cityLength-1) && !visited[r][c+1]) {
					grid[r][c+1] = 1 + grid[r][c];
					visited[r][c+1] = true;
					newBasePoints.add(new int[] {r, c+1});
				}
				
				// Up
				if (r>0 && !visited[r-1][c]) {
					grid[r-1][c] = 1 + grid[r][c];
					visited[r-1][c] = true;
					newBasePoints.add(new int[] {r-1, c});
				}
				
				// Down
				if (r<(cityWidth-1) && !visited[r+1][c]) {
					grid[r+1][c] = 1 + grid[r][c];
					visited[r+1][c] = true;
					newBasePoints.add(new int[] {r+1, c});
				}
			}
			
			if (newBasePoints.size()==0)	break;
			basePoints = newBasePoints;
		}
		
		return grid;
	}
	
	public static void printGrid(int[][] M){
		for(int r=0; r<M.length; r++){
			for(int c=0; c<M[0].length; c++){
				System.out.print(M[r][c] + ", ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		int cityLength1 = 3;
		int cityWidth1 = 5;
		int[] X1 = {1};
		int[] Y1 = {1};
		int[][] retGrid1 = getLockerDistanceGrid(cityLength1, cityWidth1, X1, Y1);
		printGrid(retGrid1);
		
		int cityLength2 = 5;
		int cityWidth2 = 7;
		int[] X2 = {2, 4};
		int[] Y2 = {3, 7};
		int[][] retGrid2 = getLockerDistanceGrid(cityLength2, cityWidth2, X2, Y2);
		printGrid(retGrid2);
		
		System.out.println("BFS approach \n");
		
		int cityLength3 = 3;
		int cityWidth3 = 5;
		int[] X3 = {1};
		int[] Y3 = {1};
		int[][] retGrid3 = bfsGrid(cityLength3, cityWidth3, X3, Y3);
		printGrid(retGrid3);
		
		int cityLength4 = 5;
		int cityWidth4 = 7;
		int[] X4 = {2, 4};
		int[] Y4 = {3, 7};
		int[][] retGrid4 = getLockerDistanceGrid(cityLength4, cityWidth4, X4, Y4);
		printGrid(retGrid4);
	}

}
