package array.productOfArray;

public class ProductOfArray {
	// Space: O(2n)
	public static int[] productExceptSelfWithSpace(int[] nums) {
        int len = nums.length;
        
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        
        prefix[0] = 1;
        for(int i=1; i<len; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        
        suffix[len-1] = 1;
        for(int i=len-2; i>=0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        
        int[] res = new int[len];
        for(int i=0; i<len; i++){
            res[i] = prefix[i]*suffix[i];
        }
        
        return res;
    }
	
	// Space: O(1)
	public static int[] productExceptSelfWithoutSpace(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        
        // Compute prefix
        res[0]=1;
        for(int i=1; i<len; i++){
            res[i] = res[i-1]*nums[i-1];
        }
        
        // Compute suffix
        int suffix=1;   // Suffix so far looking towards Right
        for(int i=len-1; i>=0; i--){
            res[i] = res[i]*suffix;
            suffix *= nums[i];
        }
        
        return res;
    }
	
	public static void printArray(int[] a) {
		System.out.print("[");
		for(int n : a)	System.out.print(n + ",");
		System.out.print("]");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1,2,3,4};
		System.out.print("With space: "); 
		printArray(productExceptSelfWithSpace(nums1));
		System.out.print("Without space: ");
		printArray(productExceptSelfWithoutSpace(nums1));
		
		System.out.println();
		System.out.println();
		
		int[] nums2 = new int[] {-1,1,0,-3,3};
		System.out.print("With space: ");
		printArray(productExceptSelfWithSpace(nums2));
		System.out.print("Without space: ");
		printArray(productExceptSelfWithoutSpace(nums2));
	}

}
