package algorithms.evaluateRPN;

import java.util.Stack;

public class EvaluateRPN {
	
	public static int evaluate(String[] expr){
		if(expr == null || expr.length==0)	return 0;
		
		int a, b;
		Stack<Integer> stack = new Stack<Integer>();		
		for(String s : expr){
			switch(s){
				case "/":
					b = stack.pop();
					a = stack.pop();
					stack.push(a/b);
					break;
					
				case "*":
					b = stack.pop();
					a = stack.pop();
					stack.push(a*b);
					break;
					
				case "+":
					b = stack.pop();
					a = stack.pop();
					stack.push(a+b);
					break;
					
				case "-":
					b = stack.pop();
					a = stack.pop();
					stack.push(a-b);
					break;
					
				default:
					stack.push(Integer.parseInt(s));
					break;
			}					
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {	
		String[] expr = {"4", "13", "5", "/", "+"}; //{"2", "1", "+", "3", "*"};
		System.out.println(evaluate(expr));
	}

}
