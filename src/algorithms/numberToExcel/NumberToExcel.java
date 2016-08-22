package algorithms.numberToExcel;

import java.util.Map;
import java.util.HashMap;

public class NumberToExcel {

	private Map<Integer, Character> map;
	
	public NumberToExcel(){
		map = new HashMap<>();
		
		// Preprocessing step.
		char base = 'A';
		for(int k=1; k<26; k++){
			map.put(k, (char) (base+k-1));
		}
		map.put(0, 'Z');
	}
	
	public String getNumberToExcelColumn(int num){
		if(num < 1)	return "";
		
		String out = "";
		while(num/26 > 0){
			int remainder = num % 26;
			out = map.get(remainder) + out;
			num = num / 26;
		}
		
		return out;
	}
	
	public static void main(String[] args) {
		
	}

}
