package algorithms.squareRoot;

public class SquareRoot {
	
	/**
	 * O(root(n))
	 * @param num
	 * @return
	 */
	public static int getSquareRoot(int num){
		if(num < 0)	return -1;
		
		int root=0;		
		int out=root;
		while(root*root <= num){
			out = root;
			root++;
		}
		return out;
	}
		
	/**
	 * O(log n); Binary search
	 * @param num
	 * @return
	 */
	public static int getSquareRootFaster(int num){
		if(num < 0)	return -1;
		if(num < 2)	return num;
		
		int start=1, end=num;
		int out=0;
		while(start<=end){
			int mid = (start+end)/2;
			if(mid*mid == num)
				return mid;				
			else if(mid*mid < num){
				start = mid + 1;
				out = mid;			// Since we need floor, we save 'out' to move closer to the root
			}
			else 
				end = mid -1;
		}
		return out;
	}
	
	
	public static void main(String[] args) {
		System.out.println(getSquareRoot(0));
		System.out.println(getSquareRoot(1));
		System.out.println(getSquareRoot(2));
		System.out.println(getSquareRoot(3));
		System.out.println(getSquareRoot(4));		
		System.out.println(getSquareRoot(7));		
		System.out.println(getSquareRoot(9));		
		System.out.println(getSquareRoot(12));
		System.out.println(getSquareRoot(100));
		System.out.println(getSquareRoot(110));
		
		System.out.println("\n");
		
		System.out.println(getSquareRootFaster(0));
		System.out.println(getSquareRootFaster(1));
		System.out.println(getSquareRootFaster(2));
		System.out.println(getSquareRootFaster(3));
		System.out.println(getSquareRootFaster(4));		
		System.out.println(getSquareRootFaster(7));		
		System.out.println(getSquareRootFaster(9));		
		System.out.println(getSquareRootFaster(12));
		System.out.println(getSquareRootFaster(100));
		System.out.println(getSquareRootFaster(110));
	}

}
