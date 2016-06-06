package algorithms.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	public static List<Integer> printSpiral(int[][] M){
		List<Integer> out = new ArrayList<>();
		
		if(M==null || M.length==0 || M[0].length==0)
			return out;
		
		int m = M.length, n = M[0].length;		
		int count = 0;
		int r=0, c=0;
		int dir = 0;			// 0-RIGHT, 1-DOWN, 2-LEFT, 3-RIGHT				
		int CIRCLECOUNT=0;		// # of circle completed/soon to be completed
				
		while(count < m*n){
			if(dir == 0){		// RIGHT
				while(c < (n-CIRCLECOUNT)){
					out.add(M[r][c]);
					c++;
					count ++;
				}				
				c--;
				r++;				
				dir = 1;		// Go DOWN
			}
			else if(dir == 1){	// DOWN
				while(r < (m-CIRCLECOUNT)){
					out.add(M[r][c]);
					r++;
					count ++;
				}
				r--;				
				c--;				
				dir = 2;		// Go LEFT
			}
			else if(dir == 2){	// LEFT
				while(c >= CIRCLECOUNT){
					out.add(M[r][c]);
					c--;
					count ++;
				}
				c++;				
				r--;				
				dir = 3;		// Go UP
			}
			else if(dir == 3){	// UP
				CIRCLECOUNT++;
				while(r >= CIRCLECOUNT){
					out.add(M[r][c]);
					r--;
					count ++;
				}
				r++;
				c++;												
				dir = 0;		// Go RIGHT
			}						
		}		
		return out;
	}
	
	public static void main(String[] args) {		
		int[][] M1 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		System.out.println(printSpiral(M1));
		
		int[][] M2 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}
		};
		System.out.println(printSpiral(M2));
		
		int[][] M3 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16},
				{17, 18, 19, 20}
		};
		System.out.println(printSpiral(M3));
	}

}
