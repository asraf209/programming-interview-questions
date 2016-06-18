package array.spiralMatrixII;

public class SpiralMatrixII {
	
	public static int[][] generateSpiralMatrix(int n){
		if(n<1)	return null;
				
		int[][] M = new int[n][n];
				
		int count = 1;
		int r=0, c=0;
		int dir = 0;			// 0-RIGHT, 1-DOWN, 2-LEFT, 3-RIGHT				
		int loopCount=0;		// # of loop completed/soon to be completed
				
		while(count <= n*n){
			if(dir == 0){		// RIGHT
				while(c < (n-loopCount)){
					M[r][c] = count;
					c++;
					count ++;
				}				
				c--;
				r++;				
				dir = 1;		// Go DOWN
			}
			else if(dir == 1){	// DOWN
				while(r < (n-loopCount)){
					M[r][c] = count;
					r++;
					count ++;
				}
				r--;				
				c--;				
				dir = 2;		// Go LEFT
			}
			else if(dir == 2){	// LEFT
				while(c >= loopCount){
					M[r][c] = count;
					c--;
					count ++;
				}
				c++;				
				r--;				
				dir = 3;		// Go UP
			}
			else if(dir == 3){	// UP
				loopCount++;
				while(r >= loopCount){
					M[r][c] = count;
					r--;
					count ++;
				}
				r++;
				c++;												
				dir = 0;		// Go RIGHT
			}						
		}		
		
		return M;
	}
	
	private static void printMatrix(int[][] M){
		for(int r=0; r<M.length; r++){
			for(int c=0; c<M[0].length; c++){
				System.out.print(M[r][c] + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {		
		int[][] out = generateSpiralMatrix(3);
		printMatrix(out);
		
		out = generateSpiralMatrix(4);
		printMatrix(out);
	}

}
