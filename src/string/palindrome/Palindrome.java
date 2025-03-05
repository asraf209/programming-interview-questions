package string.palindrome;

public class Palindrome {
	public static boolean isPalindrome(String str) {
		if(str.isEmpty())	return true;

		int s=0, e=str.length()-1;
		while (s<e) {
			while (s<e && !isAlphabate(str.charAt(s))) {
				s++;
			}
			while (s<e && !isAlphabate(str.charAt(e))) {
				e--;
			}

			if (s>=e)	return true;
			if (str.toLowerCase().charAt(s) == str.toLowerCase().charAt(e)) {
				s++;
				e--;
			}
			else return false;
		}

		return true;
	}

	static boolean isAlphabate(char ch) {
		if (ch>='A' && ch<='Z')	return true;
		if (ch>='a' && ch<='z')	return true;
		return false;
	}
	
	public static void main(String[] args) {
		String str = "!Rob#  o&r1";
		System.out.println(isPalindrome(str));

		str = "-&%$ ";
		System.out.println(isPalindrome(str));

		str = "";
		System.out.println(isPalindrome(str));

		str = "abcba";
		System.out.println(isPalindrome(str));

		str = "abh kkjhk asd";
		System.out.println(isPalindrome(str));
	}
}
