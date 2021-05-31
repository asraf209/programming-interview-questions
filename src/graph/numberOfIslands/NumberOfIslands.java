package graph.numberOfIslands;

public class NumberOfIslands {
	public static int numberOfIslands(int[][] grid) {
		if (grid==null || grid.length==0 || grid[0].length==0)	return 0;
		int count=0;
		
		// To track whether we have already visited this point or not. 
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		
		for (int r=0; r<grid.length; r++) {
			for (int c=0;c<grid[0].length; c++) {
				if (!visited[r][c] && grid[r][c]!=0) {
					// We are already an an island. So mark all other adjacent points in the same island
					// DFS
					explore(r, c, grid, visited);
					count++;
				}
			}
		}
		
		return count;
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
	
	private static void explore(int r, int c, int[][] grid, boolean[][] visited) {
		if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0 || visited[r][c])	return;
		
		visited[r][c] = true;
		
		// Explore surrounding points
		explore(r-1, c, grid, visited);
		explore(r+1, c, grid, visited);
		explore(r, c-1, grid, visited);
		explore(r, c+1, grid, visited);
	}
	
	public static void main(String args[]) {
		int[][] grid1 = {{1,1,1,1,0},
						{1,1,0,1,0},
						{1,1,0,0,0},
						{0,0,0,0,0}};
		System.out.println(numberOfIslands(grid1));
		System.out.println(numberOfIslandsV2(grid1));
		
		int[][] grid2 = {{1,1,0,0,0},
		        {1,1,0,0,0},
		        {0,0,1,0,0},
		        {0,0,0,1,1}};
		System.out.println(numberOfIslands(grid2));
		System.out.println(numberOfIslandsV2(grid2));
	}
}
