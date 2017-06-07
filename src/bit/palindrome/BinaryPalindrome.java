package bit.palindrome;

public class BinaryPalindrome {

	/**
	 * The idea is to read each bit, one at a time, of the number from right to left and 
	 * generate another number using these bits from left to right. 
	 * Finally, we compare these two numbers. If they are same, the original number is a binary bit palindrome.	 
	 * O(log2 n + 1)
	 */
	public static boolean isPalindrome(int num){
		if(num==0)	return true;
		int n = num;
		int rev = 0;
		
		while(n!=0){
			int currBit = n & 1;
			rev = rev << 1;
			rev = rev | currBit;
			n = n >> 1;
		}
		
		return rev==num;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(5));
		System.out.println(isPalindrome(12));
	}

}
