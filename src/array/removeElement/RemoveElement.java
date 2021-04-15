package array.removeElement;

public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
        if(nums==null || nums.length<1)	return 0;
        
        int p1=-1, p2=0;
        while(p2<nums.length){
        	while(p2<nums.length && nums[p2]==val)
        		p2++;
        	if(p2>=nums.length)	return (p1+1);
        	nums[p1+1] = nums[p2];
        	p1++;
        	p2++;
        }
        return (p1+1);
    }

	// Alternate solution
	public static int removeElement2(int[] nums, int val) {
        	if(nums==null || nums.length<1)	return 0;
        	int s=0, e=nums.length-1;
		
		while(s<=e){
			if(nums[s]==val){
				swap(nums, s, e);
				e--;
			}
			else	s++;
		}
		
		return e+1;
    	}
	
	public static void swap (int[] nums, int s, int e) {
		int tmp = nums[s];
		nums[s] = nums[e];
		nums[e] = tmp;
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 2, 3};
		System.out.println(removeElement(nums, 3));
	}

}
