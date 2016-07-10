package array.medianOf2SortedArrays;

public class MedianOfTwoSortedArrays {
	
	public static double getMedian(int[] nums1, int[] nums2){
		if(nums1==null || nums2==null)	return 0;		
		return getMedianHelper(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1);
	}
	
	/**
	 * O(log(m + n))
	 * Compute median for each array (m1, m2) and compare. 
	 * If m1 is greater than m2, then median is present in one of the below two sub-arrays.
    	a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
    	b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
	 * If m2 is greater than m1, then median is present in one of the below two subarrays.
   		a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
   		b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])	 
	 */
	private static double getMedianHelper(int[] nums1, int[] nums2, int s1, int e1, int s2, int e2){		
		double m1 = median(nums1, s1, e1);
		double m2 = median(nums2, s2, e2);				
		
		if(m1==0)	return m2;
		else if(m2==0)	return m1;
		
		int size1 = e1-s1+1;
		int size2 = e2-s2+1;
		
		if(size1<=2 && size2<=2)
			return	((Math.min(nums1[e1], nums2[e2]) + Math.max(nums1[s1], nums2[s2]))/2.0);					
		
		if(m1 >= m2){
			if(size1>2 && size2 > 2){
				if(size2%2==0)
					return getMedianHelper(nums1, nums2, s1, (s1+e1)/2, ((s2+e2)/2)+1, e2);
				return getMedianHelper(nums1, nums2, s1, (s1+e1)/2, (s2+e2)/2, e2);
			}
			else if(size1>2)
				return getMedianHelper(nums1, nums2, s1, (s1+e1)/2, s2, e2);
			else{
				if(size2%2==0)
					return getMedianHelper(nums1, nums2, s1, e1, ((s2+e2)/2)+1, e2);
				return getMedianHelper(nums1, nums2, s1, e1, (s2+e2)/2, e2);
			}
		}
		else{
			if(size1>2 && size2 > 2){
				if(size1%2==0)
					return getMedianHelper(nums1, nums2, ((s1+e1)/2)+1, e1, s2, (s2+e2)/2);
				return getMedianHelper(nums1, nums2, (s1+e1)/2, e1, s2, (s2+e2)/2);
			}
			else if(size1>2){
				if(size1%2==0)
					return getMedianHelper(nums1, nums2, ((s1+e1)/2)+1, e1, s2, e2);
				return getMedianHelper(nums1, nums2, (s1+e1)/2, e1, s2, e2);
			}
			else
				return getMedianHelper(nums1, nums2, s1, e1, s2, (s2+e2)/2);
		}				
	}
	
	private static double median(int[] nums, int s, int e){
		if(nums==null || nums.length<1)	return 0;
		int length = e-s+1;
		if(length<2)	return nums[0];
		if(length%2!=0)
			return nums[(s+e)/2];
		else
			return ((nums[(s+e)/2] + nums[((s+e)/2)+1])/2.0);
	}
	
	/**
	 * Linear Approach; O(n/2)
	 * Count total numbers and find the median point.
	 * Now compare elements of both the Array in a sorted order untill you reach the median point.
	 * If total (m+n) is Odd then return number from this point.
	 * Else return avg of this num and its next one
	 */
	public static double getMedianLinearApproach(int[] nums1, int[] nums2){
		if(nums1==null || nums2==null)	return 0;
		if(nums1.length<1)	return median(nums2, 0, nums2.length-1);
		else if(nums2.length<1)	return median(nums1, 0, nums1.length-1);
		
		int m = nums1.length;
		int n = nums2.length;		
		int med = 0;
		
		// Median point
		if((m+n)%2==0)	med = (m+n)/2 -1;
		else	med = (m+n)/2;
		
		int c=0;
		int i=0, j=0;		
		boolean isArr1 = false;
		while(c <= med){
			if(nums1[i]<=nums2[j]){
				i++;
				isArr1 = true;
			}
			else{ 
				j++;
				isArr1 = false;
			}
			c++;
		}				
		
		if((m+n)%2==0){
			int a=0, b=0;
			if(isArr1){
				a=nums1[i-1];
				if(nums1[i] <= nums2[j])
					b = nums1[i];
				else
					b = nums2[j];				
			}
			else{
				a=nums2[j-1];
				if(nums1[i] <= nums2[j])
					b = nums1[i];
				else
					b = nums2[j];				
			}
			return (a+b)/2.0;
		}
		else
			return isArr1?nums1[i-1]:nums2[j-1];
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1, 3};
		int[] nums2 = {2};
		System.out.println(getMedian(nums1, nums2));
		System.out.println(getMedianLinearApproach(nums1, nums2));
		
		nums1 = new int[]{1, 3};
		nums2 = new int[]{2, 4};
		System.out.println(getMedian(nums1, nums2));
		System.out.println(getMedianLinearApproach(nums1, nums2));
		
		nums1 = new int[]{1, 5, 9, 10, 15, 20};
		nums2 = new int[]{2, 3, 8, 13};
		System.out.println(getMedian(nums1, nums2));				
		System.out.println(getMedianLinearApproach(nums1, nums2));
	}

}
