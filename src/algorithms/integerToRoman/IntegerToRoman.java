package algorithms.integerToRoman;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
	private final int MAX_NUM = 3999;
	private Map<Integer, String> dict;
	
	public IntegerToRoman(){
		dict  = new HashMap<>();
		preProcess();		
	}
	
	private void preProcess(){
		dict.put(1, "I");
		dict.put(5, "V");
		dict.put(10, "X");
		dict.put(50, "L");
		dict.put(100, "C");
		dict.put(500, "D");
		dict.put(1000, "M");
	}
	
	public String convertIntegerToRoman(int num){
		if(num<=0 || num>MAX_NUM)	return "Not a valid number!";
		if(dict.containsKey(num))
			return dict.get(num);
		else{
			
		}
		return "";
	}
	
	public static void main(String[] args) {
		IntegerToRoman iToR = new IntegerToRoman();
		System.out.println(iToR.convertIntegerToRoman(1));
	}

}
