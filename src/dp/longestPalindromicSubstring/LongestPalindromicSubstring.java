package dp.longestPalindromicSubstring;

public class LongestPalindromicSubstring {

	public static String getLPS(String s){
		if(s==null || s.isEmpty())	return s;
		
		int n = s.length();
		// m[i][j] = true, if substring(i, j) is a palindrome
		boolean m[][] = new boolean[s.length()][s.length()];
		int maxLen = 1;
		int begin = 0;
		
		// Length 1 substring is always palindrome
		for(int i=0; i<n; i++)
			m[i][i] = true;
		
		// Check for length 2 substring
		for(int i=0; i<n-1; i++){
			if(s.charAt(i) == s.charAt(i+1)){
				m[i][i+1] = true;
				maxLen = 2;
				begin = i;
			}
		}
		
		// Length of 3 onward
		for(int len=3; len<=n; len++){
			for(int i=0; i<=(n-len-i); i++){
				int j = i+len-1;
				if((s.charAt(i) == s.charAt(j)) && m[i+1][j-1]){
					m[i][j] = true;
					maxLen = len;
					begin = i;
				}
			}
		}
		return s.substring(begin, begin+maxLen);
	}
	
	public static void main(String[] args) {		
		System.out.println(getLPS("aba"));
	}

}
