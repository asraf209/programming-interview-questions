package graph.maxHeight;

import java.util.ArrayList;
import java.util.List;

public class FindMaxHeight {
	
	public static int findMaxHeight(int[][] matrix)
	{
		if (matrix==null || matrix.length==0)	return 0;
		int maxHeight = 0;
		
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];
		List<int[]> basePoints = new ArrayList<>();
		
		// 0's are the base points for us to start checking neighboring points (BFS)
		for(int r=0; r<m; r++) {
			for(int c=0; c<n; c++) {
				if(matrix[r][c]==0) {
					basePoints.add(new int[] {r, c});
					visited[r][c] = true;
				}
			}
		}
		
		// There are endless possibilities for no sea point
		if (basePoints.size()==0)	return Integer.MAX_VALUE;
		
		// BFS search along neighbors
		while(true) {
			List<int[]> newBasePoints = new ArrayList<>();
			for(int[] point : basePoints) {
				int r = point[0];
				int c = point[1];
				
				// Left
				if (c>0 && !visited[r][c-1]) {
					visited[r][c-1] = true;
					matrix[r][c-1] = matrix[r][c] + 1;
					maxHeight = Math.max(maxHeight, matrix[r][c-1]);
					newBasePoints.add(new int[] {r, c-1});
				}
				
				// Right
				if (c<(n-1) && !visited[r][c+1]) {
					visited[r][c+1] = true;
					matrix[r][c+1] = matrix[r][c] + 1;
					maxHeight = Math.max(maxHeight, matrix[r][c+1]);
					newBasePoints.add(new int[] {r, c+1});
				}
				
				// Up
				if (r>0 && !visited[r-1][c]) {
					visited[r-1][c] = true;
					matrix[r-1][c] = matrix[r][c] + 1;
					maxHeight = Math.max(maxHeight, matrix[r-1][c]);
					newBasePoints.add(new int[] {r-1, c});
				}
				
				// Down
				if (r<(m-1) && !visited[r+1][c]) {
					visited[r+1][c] = true;
					matrix[r+1][c] = matrix[r][c] + 1;
					maxHeight = Math.max(maxHeight, matrix[r+1][c]);
					newBasePoints.add(new int[] {r+1, c});
				}
			}
			
			if(newBasePoints.size()==0)	break;
			basePoints = newBasePoints;
		}
		
		return maxHeight;
	}
	
	public static void main(String[] args) {	
		int[][] matrix = new int[][]{
			{0, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 0}};
		System.out.println(findMaxHeight(matrix));
	}
}
