package array.lockerLocations;

public class LockerLocations {
	
	/**
	 * Compute Distance form current (x, y) to the (lockerX, lockerY)
	 * @param r
	 * @param c
	 * @param X
	 * @param Y
	 * @return
	 */
	private static int distance(int r, int c, int[]X, int[]Y){
		int minDistance = Integer.MAX_VALUE;
		for(int i=0; i<X.length; i++){
			int distance = Math.abs(r+1-X[i]) + Math.abs(c+1-Y[i]);	// Row/Column starts from 0 
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
		int cityLength = 3;
		int cityWidth = 5;
		int[] X = {1};
		int[] Y = {1};
		int[][] retGrid = getLockerDistanceGrid(cityLength, cityWidth, X, Y);
		printGrid(retGrid);
		
		cityLength = 5;
		cityWidth = 7;
		int[] X1 = {2, 4};
		int[] Y1 = {3, 7};
		retGrid = getLockerDistanceGrid(cityLength, cityWidth, X1, Y1);
		printGrid(retGrid);
	}

}
