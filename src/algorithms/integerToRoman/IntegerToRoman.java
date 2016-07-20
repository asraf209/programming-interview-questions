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
		
		StringBuffer buffer = new StringBuffer();
		
		if(dict.containsKey(num))
			return dict.get(num);
		else{
			int[] denominators = {1000, 500, 100, 50, 10, 5, 1};
			for(int i=0; i<denominators.length; i++){
				if(num/denominators[i] > 0){					
					int count = num/denominators[i];
					if(i>0)
						buffer = getRomanNumeral(denominators[i], count, denominators[i-1], buffer);
					else
						buffer = getRomanNumeral(denominators[i], count, denominators[i], buffer);
					num = num % denominators[i];
				}
			}
		}
		return buffer.toString();
	}
	
	private StringBuffer getRomanNumeral(int d, int c, int nextD, StringBuffer buffer){
		if(dict.containsKey(d*c))
			buffer.append(dict.get(d*c));
		else if(d*c + 1*d == nextD){
			buffer.append(dict.get(d));
			buffer.append(dict.get(nextD));
		}
		else{
			for(int i=0; i<c; i++)
				buffer.append(dict.get(d));
		}
		return buffer;
	}
	
	public static void main(String[] args) {
		IntegerToRoman iToR = new IntegerToRoman();
		System.out.println(iToR.convertIntegerToRoman(1));
		System.out.println(iToR.convertIntegerToRoman(2));
		System.out.println(iToR.convertIntegerToRoman(3));
		System.out.println(iToR.convertIntegerToRoman(4));
		System.out.println(iToR.convertIntegerToRoman(5));
		System.out.println(iToR.convertIntegerToRoman(6));
		System.out.println(iToR.convertIntegerToRoman(7));
		System.out.println(iToR.convertIntegerToRoman(8));
		System.out.println(iToR.convertIntegerToRoman(9));
		System.out.println(iToR.convertIntegerToRoman(10));
	}

}
