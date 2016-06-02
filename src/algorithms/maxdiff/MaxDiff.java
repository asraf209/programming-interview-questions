package algorithms.maxdiff;

public class MaxDiff {		
	
	/**
	 * Find pair of MIN and MAX. If their difference is larger than maximum difference,
	 * then they are the possible candidate for output.
	 * Two things to track: 
	 * 		1) Max diff found so far
	 * 		2) Min number found so far
	 * 
	 * @param a; An Array of integer numbers
	 * @return Maximum difference between the MIN and MAX value, such that, 
	 * MAX number appears after MIN number
	 */
	public static int findMaxDiff(int[] a){
		if(a==null || a.length < 2)	return 0;
		
		int maxDiff = 0;
		int minPos=0, tmpMinPos=0, maxPos=0;				
		int MIN = a[0], MAX=Integer.MIN_VALUE;
		
		for(int i=1; i<a.length; i++){
			if(a[i] < MIN){
				MIN = a[i];
				tmpMinPos = i;				
			}
			else{
				MAX = a[i];
				if((MAX - MIN) > maxDiff){
					maxPos = i;
					minPos = tmpMinPos;
					maxDiff = MAX - MIN;
				}				
			}
		}
		
		System.out.println(minPos + ", " + maxPos);
		return maxDiff;
	}
	
	public static void main(String[] args) {
		System.out.println(findMaxDiff(new int[]{1, 2, 3, 4, 5}));	// minI:0, maxI:4 -> diff:4
		System.out.println(findMaxDiff(new int[]{5, 4, 3, 2, 1}));	// No satisfied min-max
		System.out.println(findMaxDiff(new int[]{5, 1, 3, 2, 4}));  // minI:1, maxI:4 -> diff:3
		System.out.println(findMaxDiff(new int[]{5, 3, 2, 1, 4}));  // minI:3, maxI:4 -> diff:3
		System.out.println(findMaxDiff(new int[]{3, 4, 1, 2, 5}));  // minI:2, maxI:4 -> diff:4
		
		System.out.println(findMaxDiff(new int[]{3, 5, 2, 1}));  	// minI:0, maxI:1 -> diff:2 
		
		System.out.println(findMaxDiff(new int[]{2, 3, 10, 6, 4, 8, 1}));  	// minI:1, maxI:4 -> diff:3
		System.out.println(findMaxDiff(new int[]{2, 3, 10, 1, 6, 4, 15}));  // minI:3, maxI:6 -> diff:14
		
		System.out.println(findMaxDiff(new int[]{2, 2, 10, 6, 4, 8, 1}));  	// minI:0, maxI:2 -> diff:8
		
		System.out.println(findMaxDiff(new int[]{7, 9, 5, 6, 3, 2}));  	// minI:0, maxI:2 -> diff:8
	}

}
