package algorithms.evaluateRPN;

import java.util.Stack;

public class EvaluateRPN {
	
	public static int evaluate(char[] expr){
		if(expr == null || expr.length==0)	return 0;
		
		int a, b;
		Stack<Integer> stack = new Stack<Integer>();		
		for(char ch : expr){
			switch(ch){
				case '/':
					b = stack.pop();
					a = stack.pop();
					stack.push(a/b);
					break;
					
				case '*':
					b = stack.pop();
					a = stack.pop();
					stack.push(a*b);
					break;
					
				case '+':
					b = stack.pop();
					a = stack.pop();
					stack.push(a+b);
					break;
					
				case '-':
					b = stack.pop();
					a = stack.pop();
					stack.push(a-b);
					break;
					
				default:
					stack.push(ch - '0');
					break;
			}					
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {	

	}

}
