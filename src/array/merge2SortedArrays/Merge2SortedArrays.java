package array.merge2SortedArrays;

public class Merge2SortedArrays {
	
	/**
	 * First array should always contain smaller elements than the second one
	 * So, if Second[start] < First[end] then swap them and sort individual Array
	 * O(m*(n+m))
	 * n - Size of First Array
	 * m - Size of Second Array
	 * 
	 * @param arr1
	 * @param arr2
	 */
	public static void mergeSortedArrays(int[] arr1, int[] arr2){
		if(arr1==null || arr2==null)	return;
		
		/**
		 * This will execute at most size(arr2) times
		 * O(m)
		 */
		while(arr2[0] < arr1[arr1.length-1]){
			// Swap elements 
			int tmp = arr2[0];
			arr2[0] = arr1[arr1.length-1];
			arr1[arr1.length-1] = tmp;
			
			/*
			 * Sort arr1, one pass is enough
			 * O(n)
			 */
			for(int i=arr1.length-1; i>0; i--){
				if(arr1[i-1] > arr1[i]){
					int n = arr1[i-1];
					arr1[i-1] = arr1[i];
					arr1[i] = n;
				}
			}
						
			/*
			 *  Sort arr2, one pass is enough
			 *  O(m)
			 */
			for(int i=1; i<arr2.length; i++){
				if(arr2[i-1] > arr2[i]){
					int n = arr2[i-1];
					arr2[i-1] = arr2[i];
					arr2[i] = n;
				}
			}
			
			//printArrays(arr1, arr2);			
		}
	}
	
	
	/**
	 * 2nd Approach
	 * Compare last items from both the Arrays. The bigger one should be in 2nd Array
	 * Swap them if they are not. Now sort the 1st Array only. Continue this process untill the size of 2nd Array
	 * O(m*n) 
	 */	
	public static void mergeSortedArrays_Solution2(int[] arr1, int[] arr2){
		if(arr1==null || arr2==null)	return;
		
		for(int j=arr2.length-1; j>=0; j--){
			if(arr1[arr1.length-1] > arr2[j]){	// Swap 
				int tmp = arr2[j];
				arr2[j] = arr1[arr1.length-1];
				arr1[arr1.length-1] = tmp;
			
				// Sort Array1
				for(int i=arr1.length-1; i>0; i--){
					if(arr1[i-1] > arr1[i]){
						int n = arr1[i-1];
						arr1[i-1] = arr1[i];
						arr1[i] = n;
					}
				}
			}
		}
				
	}
	
	public static void printArrays(int[] arr1, int[] arr2){
		for(int n : arr1)	System.out.print(n + ", ");
	    System.out.println();
	    for(int n : arr2)	System.out.print(n + ", ");
	    System.out.println("\n");
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1, 5, 9, 10, 15, 20};
	    int[] arr2 = {2, 3, 8, 13};
	    //mergeSortedArrays(arr1, arr2);   	    
	    mergeSortedArrays_Solution2(arr1, arr2);
	    printArrays(arr1, arr2);	    	   
	}

}
