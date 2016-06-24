package array.lockerLocations;

public class LockerLocations {
	
	private static int distance(int r, int c, int[]X, int[]Y){
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
