package array.lockerLocations;

public class LockerLocations {
	
	private static int distance(int r, int c, int[]X, int[]Y){
		int minDistance = Integer.MAX_VALUE;
		for(int i=0; i<X.length; i++){
			int distance = Math.abs(r+1-X[i]) + Math.abs(c+1-Y[i]);
			minDistance = Math.min(minDistance, distance);
		}
		return 0;
	}
	
	public static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] X, int[] Y){
		int[][] grid = new int[cityLength][cityWidth];
		for(int r=0; r<cityLength; r++){
			for(int c=0; c<cityWidth; c++){
				grid[r][c] = distance(r, c, X, Y);
			}
		}
		return grid;
	}
	
	public static void main(String[] args) {
		int cityLength = 3;
		int cityWidth = 5;
		int[] X = {1};
		int[] Y = {1};
		int[][] retGrid = getLockerDistanceGrid(cityLength, cityWidth, X, Y);
	}

}
