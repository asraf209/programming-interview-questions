package dp.equalSubsetSumPartition;

public class EqualSubsetSumPartition {

	/**
	 * Take one item at a time and try to find if the resulting sub-array sum is equal to our target.
	 * Mainly check every sub-array and compute its sum. O(2^n)
	 * This can also be achieved by computing all sub-array first, and then check their sum
	 * With memorization (dp), we can improve its performance
	 */
	static boolean canPartitionRecursive(int[] a, int sum, int currPos) {
		// Base cases
		if (sum==0)	return true;
		if (currPos >= a.length)	return false;

		// If current item is equal/less than Sum, we have two options
		// 		1. Include it in the sub-array, and look for remaining Sum
		//		2. Exclude/skip it totally, and try to find the Sum from remaining elements
		if (a[currPos] <= sum) {
			if(canPartitionRecursive(a, sum-a[currPos], currPos+1))
				return true;
			// Can't return false immediately, cause, we need to explore other sub-array
			else if(canPartitionRecursive(a, sum, currPos+1))
				return true;
		}

		return canPartitionRecursive(a, sum, currPos+1);
	}

	// With memorization
	static boolean canPartitionRecursive(int[] a, int sum, int currPos, Boolean[][] dp) {
		// Base cases
		if (sum==0)	return true;
		if (currPos >= a.length)	return false;

		// If we haven't processed this position yet
		if (dp[currPos][sum]==null) {
			// If current item is equal/less than Sum, we have two options
			// 		1. Include it in the sub-array, and look for remaining Sum
			//		2. Exclude/skip it totally, and try to find the Sum from remaining elements
			if (a[currPos] <= sum) {
				if(canPartitionRecursive(a, sum-a[currPos], currPos+1)) {
					dp[currPos][sum] = true;
					return true;
				}
				// Can't return false immediately, cause, we need to explore other sub-array
				else if(canPartitionRecursive(a, sum, currPos+1)) {
					dp[currPos][sum] = true;
					return true;
				}
			}

			dp[currPos][sum] = canPartitionRecursive(a, sum, currPos+1);
		}

		return dp[currPos][sum];
	}

	static boolean canPartition(int[] a) {
		if (a==null || a.length==0)	return false;
		int totalSum=0;
		for (int i=0; i<a.length; i++){
			totalSum += a[i];
		}

		// We can't partition the array into 2 subarray with equal sum, if the Total is odd
		if (totalSum%2!=0)	return false;
		// return canPartitionRecursive(a, totalSum/2, 0);

		// With dp num/sum
		Boolean[][] dp = new Boolean[a.length][totalSum/2+1];
		return canPartitionRecursive(a, totalSum/2, 0, dp);
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4};
		int[] b = {1, 1, 3, 4, 7};
		int[] c = {2, 3, 4, 6};
		System.out.println(canPartition(a));
		System.out.println(canPartition(b));
		System.out.println(canPartition(c));
	}

}
