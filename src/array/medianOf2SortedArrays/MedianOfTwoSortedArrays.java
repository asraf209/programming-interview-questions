package array.medianOf2SortedArrays;

public class MedianOfTwoSortedArrays {
	
	public static float getMedian(int[] nums1, int[] nums2){
		if(nums1==null || nums2==null)	return 0;
		return getMedianHelper(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1);
	}
	
	private static float getMedianHelper(int[] nums1, int[] nums2, int s1, int e1, int s2, int e2){
		int size1 = e1-s1+1;
		int size2 = e2-s2+1;
		if(size1<=2 && size2<=2)
			return	(float) ((Math.min(nums1[e1], nums2[e2]) + Math.max(nums1[s1], nums2[s2]))/2.0);					
		
		float m1 = median(nums1, s1, e1);
		float m2 = median(nums2, s2, e2);
		
	}
	
	private static float median(int[] nums, int s, int e){
		if(nums==null)	return 0;
		int length = e-s+1;
		if(length<2)	return nums[0];
		if(length%2==0)
			return nums[(s+e)/2];
		else
			return (float) ((nums[(s+e)/2] + nums[((s+e)/2)+1])/2.0);
	}
	
	public static void main(String[] args) {
		

	}

}
