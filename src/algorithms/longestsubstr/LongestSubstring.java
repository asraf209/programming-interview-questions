package algorithms.longestsubstr;

/**
 * Longest substring with non-repeating characters
 *
 */
public class LongestSubstring {
	public static int longestSubstring(String s){
		if(s==null || s.trim().isEmpty())	return 0;		
		
		s = s.trim();		
		int start = 0, tmpStart = 0;
		int length = 0, maxLength = 0;
		boolean[] chSet = new boolean[256];
		
		for(int i=0; i<s.length(); i++){
			int index = s.charAt(i);
			if(chSet[index]){
				if(length > maxLength){
					start = tmpStart;
					maxLength = length;
				}
				tmpStart = i+1;
			}
			else{
				length++;
				chSet[index] = true;
			}
		}
		System.out.println(s.substring(start, start+maxLength));
		return maxLength;
	}
	
	public static void main(String[] args) {
		System.out.println(longestSubstring("pwwke"));
		System.out.println(longestSubstring("abcabcbb"));
		System.out.println(longestSubstring("bbbb"));
	}

}
