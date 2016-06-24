package array.lockerLocations;

public class LockerLocations {
	
	private static int distance(int r, int c, int[]X, int[]Y){
		int minDistance = Integer.MAX_VALUE;
		for(int i=0; i<X.length; i++){
			int distance = Math.abs(r+1-X[i]) + Math.abs(c+1-Y[i]);
			minDistance = Math.min(minDistance, distance);
		}
		return minDistance;
	}
	
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
	}

}
