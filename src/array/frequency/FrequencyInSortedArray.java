package array.frequency;

public class FrequencyInSortedArray {		
	
	/**
	 * This can be solved linearly with or without storage. But that would be O(n)
	 * We want something better than that
	 */
	public static int getTargetValueFrequency(int[] a, int target){
		if (a==null || a.length < 1)	return 0;
		
		int startPos = findStartingPosition(a, 0, a.length-1, target); 
		int endPos = findEndingPosition(a, startPos, a.length-1, target);
		// We can pass 0 as starting point as well. But will be slight slower than above
		// int endPos = findEndingPosition(a, 0, a.length-1, target);
		
		if (startPos!=-1 || endPos!=-1)
			return endPos - startPos + 1;
		return 0;
	}
	
	// Binary search
	public static int findStartingPosition(int[] a, int s, int e, int target) {
		while (s<=e) {
			int mid = (s+e)/2;
			if(target == a[mid]) {
				if (mid>0 && a[mid-1]==target)	e = mid - 1;	// Search left
				else	return mid;
			}
			else if(target < a[mid])	e = mid - 1;	// Search left
			else s = mid + 1;	// Search right
		}
		
		return -1;
	}
	
	// Binary search
	public static int findEndingPosition(int[] a, int s, int e, int target) {
		while (s<=e) {
			int mid = (s+e)/2;
			if(target == a[mid]) {
				if (mid < (a.length-1) && a[mid+1]==target)	s = mid + 1;	// Search right
				else	return mid;
			}
			else if(target < a[mid])	e = mid - 1;	// Search left
			else s = mid + 1;	// Search right
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {};
		int target = 3;
		System.out.println(getTargetValueFrequency(a, target));
		
		int[] b = {1, 1, 1};
		target = 1;
		System.out.println(getTargetValueFrequency(b, target));
		
		int[] c = {1, 1, 2, 2, 2, 3, 3, 3, 3, 4};
		target = 3;
		System.out.println(getTargetValueFrequency(c, target));
		
		target = 1;
		System.out.println(getTargetValueFrequency(c, target));
		
		target = 4;
		System.out.println(getTargetValueFrequency(c, target));
	}

}
