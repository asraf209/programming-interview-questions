package array.removeDuplicatesFromSortedArray;

public class RemoveDuplicatesFromSortedArray {
	
	// O(n)
	public int removeDuplicates(int[] nums) {
        if(nums==null)	return 0;
        if(nums.length<2)	return nums.length;
                
        int dpCount = 0;
        for(int p1=0, p2=1; p2<nums.length; p1++, p2++){
        	while(p2<nums.length && nums[p1]==nums[p2]){	
        		dpCount++;
        		p2++;
        	}
        	
        	if(p2<nums.length && p2>p1+1)
        		nums[p1+1] = nums[p2];        	
        }
        
        printArray(nums, nums.length-dpCount);
        
        return nums.length-dpCount;
    }
	
	private void printArray(int[] nums, int newSize){
		for(int i=0; i<newSize; i++)	System.out.print(nums[i] + ", ");
		System.out.println();
	}

	public static void main(String[] args) {		
		RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
		int[] nums1 = {1, 1, 2};
		System.out.println(obj.removeDuplicates(nums1) + "\n");
		
		int[] nums2 = {1, 1};
		System.out.println(obj.removeDuplicates(nums2) + "\n");
		
		int[] nums3 = {1, 1, 2,2, 2,2,2,2,2,2,3};
		System.out.println(obj.removeDuplicates(nums3) + "\n");
	}

}
