package algorithms.letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LetterCombinations {

	public static List<String> getLetterCombinations(String digits){
		if(digits==null || digits.isEmpty())	return new ArrayList<>();
		
		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
				
		List<String> inputStr = new ArrayList<>();
		for(char ch : digits.toCharArray()){
			if(map.containsKey(ch))
				inputStr.add(map.get(ch));
		}
		
		Queue<String> queue = new LinkedList<>();
		for(String s : inputStr){
			if(queue.isEmpty()){
				for(char ch : s.toCharArray())
					queue.add(""+ch);
				continue;
			}
			
			int qsize = queue.size();			
			int j=0;
			while(j<qsize){
				String pop = queue.poll();
				for(char ch : s.toCharArray()){					
					queue.add(pop+ch);
				}
				j++;
			}			
		}
		return (List<String>) queue;
	}
	
	public static void main(String[] args) {		
		System.out.println(getLetterCombinations("23"));
	}

}
