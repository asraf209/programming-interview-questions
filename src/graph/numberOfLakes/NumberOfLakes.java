package graph.numberOfLakes;

public class NumberOfLakes {
	
	public static int numberOfLakes(int[][] grid) {
		if (grid==null || grid.length==0 || grid[0].length==0)	return 0;
		int count=0;
		
		for (int r=0; r<grid.length; r++) {
			for (int c=0;c<grid[0].length; c++) {
				if (grid[r][c]==0) {
					// We are in a water body. This could be possibly a lake
					// DFS
					count = exploreLake(r, c, grid) ? count+1 : count;
				}
			}
		}
		
		return count;
	}
	
	private static boolean exploreLake(int r, int c, int[][] grid) {
		if(r<0 || c<0 || r>=grid.length || c>=grid[0].length)	return false;
		if (grid[r][c]==1)	return true;
		
		grid[r][c] = 1;
		
		// Explore surrounding points
		return
				exploreLake(r-1, c, grid) &	//left
				exploreLake(r+1, c, grid) &	//right
				exploreLake(r, c-1, grid) &	//up
				exploreLake(r, c+1, grid);	//down
	}
	
	public static void main(String args[]) {
		System.out.println("Number of lakes: ");
		int[][] grid1 = {{0,1,0},
						 {1,0,1},
						 {1,1,0}};
		System.out.println(numberOfLakes(grid1));

		int[][] grid2 = {{1,1,1,1,0},
						 {1,1,0,1,0},
						 {1,1,0,0,1},
						 {0,0,1,1,0}};
		System.out.println(numberOfLakes(grid2));
		
		int[][] grid3 = {{1,1,0,0,0},
		        		 {1,1,0,0,0},
		        		 {0,0,1,0,0},
		        		 {0,0,0,1,1}};
		System.out.println(numberOfLakes(grid3));

		int[][] grid4 = {{1,1,1,1,0},
						 {1,0,0,1,1},
						 {1,0,1,0,1},
						 {0,1,0,1,1}};
		System.out.println(numberOfLakes(grid4));
	}
}
