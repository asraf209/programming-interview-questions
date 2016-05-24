package algorithms.rpn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RPN {

	private static List<String> makeRPN(String s){
		Stack<String> operators = new Stack<>();		
		List<String> rpn = new ArrayList<>();		// Output
		StringBuffer sbf = new StringBuffer();		// Holds each number
		
		for(char c : s.toCharArray()){
			// Initialize buffer to fetch next number
			if(c==' ' || c=='(' || c==')' || c=='+' || c=='-'){
				if(sbf.length()!=0){
					rpn.add(sbf.toString());
					sbf.setLength(0);
					
					// (-)ve has more precedence over (+)ve
					if(!operators.isEmpty() && operators.peek().equals("-"))				
						rpn.add(operators.pop());
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
					rpn.add(p);
					p = operators.pop();
				}
				// (-)ve has more precedence over (+)ve
				if(!operators.isEmpty() && operators.peek().equals("-"))
					rpn.add(operators.pop());
			}
			else{
				sbf.append(c);		
			}
		}
		if(sbf.length()!=0){
			rpn.add(sbf.toString());			
		}
		
		if(!operators.isEmpty()){
			while(!operators.isEmpty())
				rpn.add(operators.pop());
		}
		
		return rpn;
	}
	
	public static void main(String[] args) {
		System.out.println(makeRPN("2+4"));
		System.out.println(makeRPN("2-3+4"));
		System.out.println(makeRPN("(1+(4+5+2)-3)+(6+8)"));
		System.out.println(makeRPN("1234"));
		System.out.println(makeRPN("(7)-(0)+(4)"));
		System.out.println(makeRPN("(7)+(0)+(4)"));		
	}	
}

/**
 * 	[2, 4, +]
	[2, 3, -, 4, +]
	[1, 4, 5, 2, +, +, 3, -, +, 6, 8, +, +]
	[1234]
	[7, 0, -, 4, +]
 */
