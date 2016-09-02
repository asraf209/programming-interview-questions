package string.anagrams;

import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

	public static void printAnagrams(String[] dict){
		if(dict==null || dict.length==0)	return;		
		Map<String, List<Integer>> mapAnagram = new HashMap<>();
		
		for(int i=0; i<dict.length; i++){
			String sign = getSign(dict[i]);
			if(mapAnagram.containsKey(sign)){
				List<Integer> indexes = mapAnagram.get(sign);
				indexes.add(i);
			}
			else{
				List<Integer> indexes = new ArrayList<>();
				indexes.add(i);
				mapAnagram.put(sign, indexes);
			}
		}
		
		// Printing
		for(String sign : mapAnagram.keySet()){
			for(int index : mapAnagram.get(sign)){
				System.out.print(dict[index] + ", ");
			}						
		}
	}
	
	private static String getSign(String word){
		if(word==null || word.isEmpty())	return "";
		char[] chSet = word.toCharArray();
		Arrays.sort(chSet);
		return String.valueOf(chSet);
	}
	
	public static void main(String[] args) {
		String[] dictionary = {"act", "pot", "cat", "top", "add",  "opt", "dad"};
		printAnagrams(dictionary);
	}

}
