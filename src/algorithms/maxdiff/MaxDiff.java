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
		
		return (minPos < maxPos) ? (MAX - MIN) : 0;
	}
	
	public static void main(String[] args) {	

	}

}
