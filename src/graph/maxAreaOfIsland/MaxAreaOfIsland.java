package graph.maxAreaOfIsland;

public class MaxAreaOfIsland {
	
	public static int maxAreaOfIsland(int[][] grid) {
		if (grid==null || grid.length==0 || grid[0].length==0)	return 0;
		int maxArea = 0;
		for (int r=0; r<grid.length; r++) {
			for (int c=0;c<grid[0].length; c++) {
				if (grid[r][c]==1) {
					// We are already in an island. Recursively explore other adjacent area. DFS
					// explore(r, c, grid);
					int area = explore(r, c, grid);
					maxArea = Math.max(area, maxArea);
				}
			}
		}
		
		return maxArea;
	}
	
	// From current (r, c), recursively explore surrounding points
	private static int explore(int r, int c, int[][] grid) {
		if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0)	return 0;
		
		grid[r][c] = 0;
		return 1 + explore(r-1, c, grid) + explore(r+1, c, grid) + explore(r, c-1, grid) + explore(r, c+1, grid);
	}
	
	public static void main(String args[]) {
		int[][] grid1 = {{1,1,1,1,0},
						 {1,1,0,1,0},
						 {1,1,0,0,0},
						 {0,0,0,0,0}};
		System.out.println(maxAreaOfIsland(grid1));
		
		int[][] grid2 = {{1,1,0,0,0},
		        		 {1,1,0,0,0},
		        		 {0,0,1,0,0},
		        		 {0,0,0,1,1}};
		System.out.println(maxAreaOfIsland(grid2));
		
		int[][] grid3 = {{0,0,0,0,0,0,0,0}};
		System.out.println(maxAreaOfIsland(grid3));
		
		int[][] grid4 = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
						 {0,0,0,0,0,0,0,1,1,1,0,0,0},
						 {0,1,1,0,1,0,0,0,0,0,0,0,0},
						 {0,1,0,0,1,1,0,0,1,0,1,0,0},
						 {0,1,0,0,1,1,0,0,1,1,1,0,0},
						 {0,0,0,0,0,0,0,0,0,0,1,0,0},
						 {0,0,0,0,0,0,0,1,1,1,0,0,0},
						 {0,0,0,0,0,0,0,1,1,0,0,0,0}};
		System.out.println(maxAreaOfIsland(grid4));
	}
}
