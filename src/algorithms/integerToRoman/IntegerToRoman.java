package algorithms.integerToRoman;

public class IntegerToRoman {	
	
	public String convertIntegerToRoman(int num){
		if(num<=0 || num>3999)	return "Not a valid number!";
		
		String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] M = {"", "M", "MM", "MMM"};
		
		return M[num/1000] + C[(num%1000)/100] + X[((num%1000)%100)/10] + I[((num%1000)%100)%10]; 				
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
		System.out.println(iToR.convertIntegerToRoman(19));
		System.out.println(iToR.convertIntegerToRoman(40));
		System.out.println(iToR.convertIntegerToRoman(400));
		System.out.println(iToR.convertIntegerToRoman(3999));
	}

}
