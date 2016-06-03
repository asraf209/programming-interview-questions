package algorithms.validateRPN;

import java.util.Stack;

public class ValidateRPN {
	public static boolean validateRPN(String expr){
		if(expr==null || expr.trim().isEmpty() || expr.trim().length()<3)
			return false;
		
		char dummy = ' ';
		Stack<Character> stack = new Stack<>();
		for(char ch : expr.trim().toCharArray()){
			if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
				if(stack.size() < 2)	return false;
				stack.pop();
				stack.pop();
				stack.push(dummy);
			}
			else
				stack.push(ch);
		}
		
		return stack.size() == 1;
	}
	
	public static void main(String[] args) {
		System.out.println(validateRPN("25+"));
		System.out.println(validateRPN("25++"));
		System.out.println(validateRPN("2-5"));
		System.out.println(validateRPN("538*+"));		
	}

}
