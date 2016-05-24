package algorithms.rpn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RPN {

	private static String convertToReversePolishNotation2(String s){
		Stack<String> operators = new Stack<>();
		//List<String> rpn = new ArrayList<>();
		StringBuffer rpn = new StringBuffer();
		StringBuffer sbf = new StringBuffer();
		
		for(char c : s.toCharArray()){
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
				//if(!operators.isEmpty() && operators.peek().equals("-"))
					//rpn.add(operators.pop());
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
		System.out.println(rpn);
		return rpn.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
