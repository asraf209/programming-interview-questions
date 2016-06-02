package algorithms.maxdiff;

public class MaxDiff {		
	
	/**
	 * Find pair of MIN and MAX. If their difference is larger than maximum difference,
	 * then they are the possible candidate for output.
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
		System.out.println(findMaxDiff(new int[]{1, 2, 3, 4, 5}));
		System.out.println(findMaxDiff(new int[]{5, 4, 3, 2, 1}));
		System.out.println(findMaxDiff(new int[]{5, 1, 3, 2, 4}));
		System.out.println(findMaxDiff(new int[]{5, 3, 2, 1, 4}));
		System.out.println(findMaxDiff(new int[]{3, 4, 1, 2, 5}));
		System.out.println(findMaxDiff(new int[]{3, 5, 2, 1})); 
		System.out.println(findMaxDiff(new int[]{2, 3, 10, 6, 4, 8, 1}));
		System.out.println(findMaxDiff(new int[]{2, 3, 10, 1, 6, 4, 15}));
	}

}
