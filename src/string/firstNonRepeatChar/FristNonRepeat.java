package string.firstNonRepeatChar;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
		
	/**
	 * This is faster than the previous one. 
	 * Here we are not going over the whole text. But only over the map.
	 * Use case: Imagine a text of thousands chars with only 4 non repeating chars
	 */
	public static char findFirstNonRepeatFast(String s){
		if(s==null || s.isEmpty())	return '\0';
		Map<Character, Integer>	map = new LinkedHashMap<>();
		for(char ch : s.toCharArray()){
			if(map.containsKey(ch)){
				int count = map.get(ch);
				map.put(ch, count+1);
			}
			else
				map.put(ch, 1);
		}
		
		for(char key : map.keySet()){
			if(map.get(key)==1)
				return key;
		}
			
		return '\0';
	}
	
	public static void main(String[] args) {		
		System.out.println(findFirstNonRepeat("total"));
		System.out.println(findFirstNonRepeatFast("total"));
	}

}
