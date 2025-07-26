package string.validparenthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
	
	public static boolean isValidParenthesis(String s) {
        if(s==null || s.isEmpty())	return true;
		
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

	// Extension: Take the list of parenthesis pairs as input parameters, <opening, closing>
	public static boolean isValidParenthesisV2(String s, Map<Character, Character> parenthesisMap) {
		if(s==null || s.isEmpty())	return true;

		Stack<Character> chStack = new Stack<Character>();

		for(char ch : s.toCharArray()){
			if (parenthesisMap.containsKey(ch))
				chStack.push(ch);
			else if(parenthesisMap.containsValue(ch)){
				if(chStack.isEmpty())	return false;
				char pop = chStack.pop();
				if(Math.abs(ch-pop) > 2)	return false;
			}
		}

		return chStack.isEmpty();
	}
	
	public static void main(String[] args) {		
		System.out.println(isValidParenthesis("()"));
		System.out.println(isValidParenthesis("()}"));
		System.out.println(isValidParenthesis("[(){[}]"));
		System.out.println();

		System.out.println(isValidParenthesis("ab(c)d"));
		System.out.println(isValidParenthesis("a{b(c)d}e"));
		System.out.println(isValidParenthesis("a[{b(c)d}ef]as"));
		System.out.println();

		System.out.println(isValidParenthesis("a[{b(c}d}ef]as"));
		System.out.println();

		// Extension
		Map<Character, Character> parenthesisMap = new HashMap<>();
		parenthesisMap.put('(', ')');
		parenthesisMap.put('{', '}');
		parenthesisMap.put('[', ']');

		System.out.println(isValidParenthesisV2("()", parenthesisMap));
		System.out.println(isValidParenthesisV2("()}", parenthesisMap));
		System.out.println(isValidParenthesisV2("[(){[}]", parenthesisMap));
		System.out.println();

		System.out.println(isValidParenthesisV2("ab(c)d", parenthesisMap));
		System.out.println(isValidParenthesisV2("a{b(c)d}e", parenthesisMap));
		System.out.println(isValidParenthesisV2("a[{b(c)d}ef]as", parenthesisMap));
		System.out.println();

		System.out.println(isValidParenthesisV2("a[{b(c}d}ef]as", parenthesisMap));
		System.out.println();
	}
}
