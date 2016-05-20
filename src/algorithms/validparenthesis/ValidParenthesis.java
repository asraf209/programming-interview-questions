package algorithms.validparenthesis;

import java.util.Stack;

public class ValidParenthesis {
	
	public static boolean isValid(String s) {
        if(s==null || s.isEmpty())	return false;
		
        Stack<Character> chStack = new Stack<Character>();
		
        for(char ch : s.toCharArray()){
			if(ch=='(' || ch=='{' || ch=='[')
				chStack.push(ch);
			else if(ch==')' || ch=='}' || ch==']'){
				if(chStack.isEmpty())	return false;
				char pop = chStack.pop();
				if(Math.abs(ch-pop) > 2)	return false;
			}
		}
        
		return chStack.isEmpty();
    }
	
	public static void main(String[] args) {		
		System.out.println(isValid("()"));
		System.out.println(isValid("()}"));
		System.out.println(isValid("[(){[}]"));
	}
}

/**
 * Output:
 * true
 * false
 * false
 */
