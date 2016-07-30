package dp.coinchange.totalWays;

public class CoinChange {

	static int findTotalWaysForCoinChange(int[] d, int S){
		if(d==null || d.length<1 || S<0)	return 0;
		else if(S==0)	return 1;
		
		int[][] dp = new int[S+1][d.length+1];
		
		// For 0 change, only one solution; do not take any of the coin
		for(int i=0; i<d.length+1; i++)
			dp[0][i] = 1;
		
		// If there are no coins, then dp[s][0] is 0 (They are 0 by default)
		
		for(int r=1; r<=S; r++){
			for(int c=1; c<=d.length; c++){
				// This coin is less then the amount we want to make change
				// Two options:
				//		1. Include this coin
				//		2. Exclude this coin
				if(d[c-1] <= r){
					dp[r][c] =	dp[r-d[c-1]][c]	 		// If you include then deduct the amount this coin
							  + dp[r][c-1];				// If you exclude then the soln will be upto the previous coin
				}
				// Else solution will be same as discarding this coin
				else
					dp[r][c] = dp[r][c-1];
			}
		}
		
		return dp[S][d.length];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
