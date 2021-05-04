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
		
		int[][] grid2 = {{1,1,0,0,0},
		        {1,1,0,0,0},
		        {0,0,1,0,0},
		        {0,0,0,1,1}};
		System.out.println(numberOfIslands(grid2));
	}
}
