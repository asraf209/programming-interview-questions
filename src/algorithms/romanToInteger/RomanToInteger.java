package algorithms.romanToInteger;

import java.util.Map;
import java.util.HashMap;

public class RomanToInteger {

	public static int convertRomanToInteger(String roman){
		if(roman==null || roman.isEmpty())	return 0;
				
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int len = roman.length();
		int out = map.get(roman.charAt(len-1));
		for(int i=len-2; i>=0; i--){
			int curr = map.get(roman.charAt(i));
			int next = map.get(roman.charAt(i+1));
			
			if(curr < next)
				out -= map.get(roman.charAt(i));
			else
				out += map.get(roman.charAt(i));			
		}
		return out;
	}
	
	public static void main(String[] args) {
		System.out.println(convertRomanToInteger("I"));
		System.out.println(convertRomanToInteger("XIX"));
		System.out.println(convertRomanToInteger("MCMLIV"));
		System.out.println(convertRomanToInteger("MMM"));
		System.out.println(convertRomanToInteger("DCXXI"));
	}

}
