package string.longestsubstr;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest substring with non-repeating characters
 */
public class LongestSubstring {	
	
	/**
	 * Sliding Window problem.
	 * Maintain two pointers and find a window which has all unique char.
	 * Use Map to check repeating char in a window
	 * When you find a repeating char, walk the left pointer and remove all chars
	 * which are unique. Next window will begin from current position(right)
	 * 
	 * @param s, input String
	 * @return length of the non-repeating substring
	 */		
	public static int longestSubstring(String s){
		if(s==null || s.trim().isEmpty())	return 0;		
		
		s = s.trim();	
		int start = 0;
		int left=0, right=0;
		int maxLength=0;
		Map<Character, Boolean> map = new HashMap<>();
		
		while(right < s.length()){
			if(map.containsKey(s.charAt(right))){
				if((right-left) > maxLength){
					maxLength = right - left;
					start = left;
				}
				while(s.charAt(left) != s.charAt(right)){
					map.remove(s.charAt(left));
					left++;
				}
				left++;
				right++;
			}
			else{
				map.put(s.charAt(right), true);
				right++;				
			}
		}
		if((s.length() - left) > maxLength){
			start = left;
			maxLength = s.length() - left;			
		}
		
		System.out.println(s.substring(start, start+maxLength));
		return maxLength;
	}	
	
	public static void main(String[] args) {
		System.out.println(longestSubstring("pwwke") + "\n");
		System.out.println(longestSubstring("pwawke") + "\n");
		System.out.println(longestSubstring("abcabcd") + "\n");
		System.out.println(longestSubstring("bbbb") + "\n");
		System.out.println(longestSubstring("dvdf") + "\n");
		System.out.println(longestSubstring("asjrgapa") + "\n");
	}

}
