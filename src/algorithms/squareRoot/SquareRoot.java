package algorithms.squareRoot;

public class SquareRoot {
	
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
	
	public static void main(String[] args) {
		System.out.println(getSquareRoot(0));
		System.out.println(getSquareRoot(1));
		System.out.println(getSquareRoot(2));
		System.out.println(getSquareRoot(3));
		System.out.println(getSquareRoot(4));
		System.out.println(getSquareRoot(5));
		System.out.println(getSquareRoot(6));
		System.out.println(getSquareRoot(7));
		System.out.println(getSquareRoot(8));
		System.out.println(getSquareRoot(9));
		System.out.println(getSquareRoot(10));
		System.out.println(getSquareRoot(11));
		System.out.println(getSquareRoot(12));
	}

}
