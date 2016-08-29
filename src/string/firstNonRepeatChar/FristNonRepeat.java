package string.firstNonRepeatChar;

import java.util.HashMap;
import java.util.Map;

/**
 * Trivial one. 
 * O(2n)
 */
public class FristNonRepeat {
	public static char findFirstNonRepeat(String s){
		if(s==null || s.isEmpty())	return '\0';
		Map<Character, Integer> map = new HashMap<>();
		for(char ch : s.toCharArray()){
			if(map.containsKey(ch)){
				int count = map.get(ch);
				map.put(ch, count+1);
			}
			else
				map.put(ch, 1);
		}
		
		for(char ch : s.toCharArray()){
			if(map.get(ch)==1)
				return ch;
		}
		
		return '\0';
	}
	
	public static void main(String[] args) {		
		System.out.println(findFirstNonRepeat("total"));
	}

}
