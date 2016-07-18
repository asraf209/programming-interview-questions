package algorithms.integerToRoman;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
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
		if(num<=0)	return "";
		
	}
	
	public static void main(String[] args) {
		
	}

}
