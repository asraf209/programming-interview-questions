package algorithms.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	public static List<Integer> printSpiral(int[][] M){
		if(M==null || M.length==0 || M[0].length==0)
			return null;
		
		int m = M.length, n = M[0].length;		
		int count = 0;
		int r=0, c=0;
		int dir = 0;			// 0-RIGHT, 1-DOWN, 2-LEFT, 3-RIGHT				
		int SPIRALCOUNT=0;		// # of spiral visited/soon to be visited
		List<Integer> out = new ArrayList<>();
		
		while(count < m*n){
			if(dir == 0){		// RIGHT
				while(c < (n-SPIRALCOUNT)){
					out.add(M[r][c]);
					c++;
				}				
				c--;
				r++;				
				dir = 1;		// Go DOWN
			}
			else if(dir == 1){	// DOWN
				while(r < (m-SPIRALCOUNT)){
					out.add(M[r][c]);
					r++;
				}
				r--;				
				c--;				
				dir = 2;		// Go LEFT
			}
			else if(dir == 2){	// LEFT
				while(c >= SPIRALCOUNT){
					out.add(M[r][c]);
					c--;
				}
				c++;				
				r--;				
				dir = 3;		// Go UP
			}
			else if(dir == 3){	// UP
				SPIRALCOUNT++;
				while(r >= SPIRALCOUNT){
					out.add(M[r][c]);
					r--;
				}
				r++;
				c++;												
				dir = 0;		// Go RIGHT
			}			
			count ++;
		}		
		return out;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	}

}
