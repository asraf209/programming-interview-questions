package intervals.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public static int[][] merge(int[][] intervals) {
        // Sort the 2-D array based on start
        // Arrays.sort(intervals, (int[] a, int[] b) -> (a[0] - b[0]));
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // First range
        int minX = intervals[0][0];
        int maxY = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        
        for (int i=1; i<intervals.length; i++){
            if(intervals[i][0] <= maxY){
                maxY = Math.max(maxY, intervals[i][1]);
            }
            else{
                list.add(new int[]{minX, maxY});
                
                minX = intervals[i][0];
                maxY = intervals[i][1];
            }
        }
        
        list.add(new int[]{minX, maxY});
        return list.toArray(new int[list.size()][]);
    }
	
	public static void print(int[][] intervals) {
		System.out.print("[");
		for (int[] is : intervals) {
			System.out.print("[");
			for (int is2 : is) {
				System.out.print(is2+",");
			}
			System.out.print("]");
		}
		System.out.print("] \n");
	}
	
	public static void main(String[] args) {
		int[][] a = {{1,3},{2,6},{8,10},{15,18}};
		print(a);
		print(merge(a));
		
		System.out.println();
		
		int[][] b = {{1,4},{4,5}};
		print(b);
		print(merge(b));
	}

}
