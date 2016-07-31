package dp.coinchange.minCoins;

public class MinCoins {

	// O(m*n)
	static int findMinimumCoinsToMakeAChange(int[] d, int S){
		if(d==null || d.length<1 || S<0)	return 0;
		else if(S==0)	return 0;
		
		int[] minCoins = new int[S+1];
		for(int s=1; s<=S; s++)
			minCoins[s] = Integer.MAX_VALUE;
		
		for(int s=1; s<=S; s++){
			for(int c=0; c<d.length; c++){
				if(d[c]<=s){
					int min = 1 + minCoins[s-d[c]];
					if(min < minCoins[s])
						minCoins[s] = min;
				}
			}
		}
		
		return minCoins[S];
	}
		
	public static void main(String[] args) {
		int[] d = {1, 2, 3};
		System.out.println(findMinimumCoinsToMakeAChange(d, 5));
	}

}
