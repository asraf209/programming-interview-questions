package algorithms.validateRPN;

public class ValidateRPN {
	public static boolean validateRPN(String expr){
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(validateRPN("25+"));
		System.out.println(validateRPN("25++"));
		System.out.println(validateRPN("2-5"));
		System.out.println(validateRPN("538*+"));
	}

}
