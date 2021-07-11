package graph.numberOfIslands;

public class NumberOfIslands {
	
	public static int numberOfIslandsV1(int[][] grid) {
		if (grid==null || grid.length==0 || grid[0].length==0)	return 0;
		int count=0;
		
		for (int r=0; r<grid.length; r++) {
			for (int c=0;c<grid[0].length; c++) {
				if (grid[r][c]==1) {
					// We are already in an island. So mark adjacent points as water 
					// DFS
					++count;
					explore(r, c, grid);
				}
			}
		}
		
		return count;
	}
	
	private static void explore(int r, int c, int[][] grid) {
		if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0)	return;
		
		grid[r][c] = 0;
		
		// Explore surrounding points
		explore(r-1, c, grid);
		explore(r+1, c, grid);
		explore(r, c-1, grid);
		explore(r, c+1, grid);
	}
	
	
	// Alternative approach to just check Left and Up (surrounding)
	public static int numberOfIslandsV2(int[][] grid) {
		if (grid==null || grid.length==0 || grid[0].length==0)	return 0;
		int count=0;
		
		for (int r=0; r<grid.length; r++) {
			for (int c=0;c<grid[0].length; c++) {
				if (grid[r][c] == 1 && !isSurroundingAnIsland(grid, r, c)) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	private static boolean isSurroundingAnIsland(int[][] grid, int r, int c) {
		if (r>0 && grid[r-1][c] == 1)	return true;
		if (c>0 && grid[r][c-1] == 1)	return true;
		return false;
	}
	
	public static void main(String args[]) {
		int[][] grid1 = {{1,1,1,1,0},
						 {1,1,0,1,0},
						 {1,1,0,0,0},
						 {0,0,0,0,0}};
		System.out.println(numberOfIslandsV1(grid1));
		//System.out.println(numberOfIslandsV2(grid1));
		
		int[][] grid2 = {{1,1,0,0,0},
		        		 {1,1,0,0,0},
		        		 {0,0,1,0,0},
		        		 {0,0,0,1,1}};
		System.out.println(numberOfIslandsV1(grid2));
		//System.out.println(numberOfIslandsV2(grid2));
	}
}
