package algorithms.longestsubstr;

import java.util.HashMap;
import java.util.Map;

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
		Map<Character, Boolean> map = new HashMap<>();
		
		for(int i=0; i<s.length(); i++){			
			if(map.containsKey(s.charAt(i))){				
				if(length > maxLength){
					start = tmpStart;
					maxLength = length;
				}
				map.clear();
				map.put(s.charAt(i), true);
				tmpStart = i;
				length = 1;
			}
			else{
				length++;
				map.put(s.charAt(i), true);
			}
		}
		if(length > maxLength){
			start = tmpStart;
			maxLength = length;
		}
		
		System.out.println(s.substring(start, start+maxLength));
		return maxLength;
	}
	
	public static void main(String[] args) {
		System.out.println(longestSubstring("pwwke"));
		System.out.println(longestSubstring("abcabcd"));
		System.out.println(longestSubstring("bbbb"));
	}

}
