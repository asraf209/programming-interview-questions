package algorithms.rpn;

import java.util.Stack;

public class RPN {

	private static String makeRPN(String s){
		Stack<String> operators = new Stack<>();		
		StringBuffer rpn = new StringBuffer();		// Output
		StringBuffer sbf = new StringBuffer();		// Holds each number
		
		for(char c : s.toCharArray()){
			// Initialize buffer to fetch next number
			if(c==' ' || c=='(' || c==')' || c=='+' || c=='-'){
				if(sbf.length()!=0){
					rpn.append(sbf.toString());
					sbf.setLength(0);
					
					// (-)ve has more precedence over (+)ve
					if(!operators.isEmpty() && operators.peek().equals("-"))
						rpn.append(operators.pop());
				}				
			}
			
			if(c==' ')	continue;							
			else if(c=='(' || c=='+' || c=='-'){
				// (-)ve has more precedence over (+)ve				
				operators.push(""+c);
			}
			else if(c==')'){
				String p = operators.pop();
				while(!p.equals("(")){
					rpn.append(p);
					p = operators.pop();
				}
				// (-)ve has more precedence over (+)ve
				if(!operators.isEmpty() && operators.peek().equals("-"))
					rpn.append(operators.pop());
			}
			else{
				sbf.append(c);		
			}
		}
		if(sbf.length()!=0){
			rpn.append(sbf.toString());			
		}
		
		if(!operators.isEmpty()){
			while(!operators.isEmpty())
				rpn.append(operators.pop());
		}
		
		return rpn.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(makeRPN("2+4"));
		System.out.println(makeRPN("2-3+4"));
		System.out.println(makeRPN("(1+(4+5+2)-3)+(6+8)"));
		System.out.println(makeRPN("1234"));
		System.out.println(makeRPN("(7)-(0)+(4)"));		
	}	
}

/**
 * 	24+
	23-4+
	1452++3-+68++
	1234
	70-4+
	2+(
 */
