package algorithms.numberToExcel;

import java.util.Map;
import java.util.HashMap;

public class NumberToExcel {

	private Map<Integer, Character> map;
	
	public NumberToExcel(){
		map = new HashMap<>();
		
		// Preprocessing step.
		char base = 'A';
		for(int k=1; k<=26; k++){
			map.put(k, (char) (base+k-1));
		}		
	}
	
	public String getNumberToExcelColumn(int num){
		if(num < 1)	return "";
		
		String out = "";
		while(num > 0){
			int remainder = num % 26;
			num = num / 26;
			
			// For 26 the remainder will be 0, which is equivalent to 'Z'
			if(remainder==0){
				out = map.get(26) + out;
				num = num - 1;
			}
			else
				out = map.get(remainder) + out;			
		}
		
		return out;
	}
	
	public static void main(String[] args) {
		NumberToExcel numberToExcel = new NumberToExcel();		
		System.out.println(numberToExcel.getNumberToExcelColumn(19));
		System.out.println(numberToExcel.getNumberToExcelColumn(26));
		System.out.println(numberToExcel.getNumberToExcelColumn(52));
		System.out.println(numberToExcel.getNumberToExcelColumn(704));
	}

}
