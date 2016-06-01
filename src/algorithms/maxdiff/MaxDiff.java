package algorithms.maxdiff;

public class MaxDiff {
	
	public static int findMaxDiff(int[] a){
		if(a==null || a.length < 2)	return 0;
		
		int minPos=0, maxPos=-1;
		int MIN = a[0], MAX=Integer.MIN_VALUE;
		
		for(int i=1; i<a.length; i++){
			if(a[i] < MIN){
				MIN = a[i];
				minPos = i;				
			}
			else{
				MAX = a[i];
				maxPos = i;
			}
		}
		System.out.println(minPos + ", " + maxPos);
		return (minPos < maxPos) ? (MAX - MIN) : 0;
	}
	
	public static void main(String[] args) {
		System.out.println(findMaxDiff(new int[]{1, 2, 3, 4, 5}));
		System.out.println(findMaxDiff(new int[]{5, 4, 3, 2, 1}));
		System.out.println(findMaxDiff(new int[]{5, 1, 3, 2, 4}));
		System.out.println(findMaxDiff(new int[]{5, 3, 2, 1, 4}));
		System.out.println(findMaxDiff(new int[]{3, 4, 1, 2, 5}));
		System.out.println(findMaxDiff(new int[]{3, 5, 2, 1}));   // Failing
	}

}
