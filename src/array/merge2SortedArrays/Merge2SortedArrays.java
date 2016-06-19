package array.merge2SortedArrays;

public class Merge2SortedArrays {
	
	public static void mergeSortedArrays(int[] arr1, int[] arr2){
		if(arr1==null || arr2==null)	return;
		
		while(arr2[0] < arr1[arr1.length-1]){
			// Swap elements 
			int tmp = arr2[0];
			arr2[0] = arr1[arr1.length-1];
			arr1[arr1.length-1] = tmp;
			
			// Sort arr1
			for(int i=arr1.length-1; i>0; i--){
				if(arr1[i-1] > arr1[i]){
					int n = arr1[i-1];
					arr1[i-1] = arr1[i];
					arr1[i] = n;
				}
			}
						
			// Sort arr2
			for(int i=1; i<arr2.length-1; i++){
				if(arr2[i-1] > arr2[i]){
					int n = arr2[i-1];
					arr2[i-1] = arr2[i];
					arr2[i] = n;
				}
			}
			
						
		}
	}
		
	
	public static void main(String[] args) {
		int[] arr1 = {1, 5, 9, 10, 15, 20};
	    int[] arr2 = {2, 3, 8, 13};
	    mergeSortedArrays(arr1, arr2);   
	    
	    for(int n : arr1)	System.out.print(n + ", ");
	    System.out.println();
	    for(int n : arr2)	System.out.print(n + ", ");
	}

}
