package algorithms.minRemove;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinRemoveToMakeValidParentheses {
	
	public static String isValid(String s) {
        if(s==null || s.isEmpty())	return s;
		
        Stack<Integer> stack = new Stack<>();
		Set<Integer> invalidIndex = new HashSet<>();

        for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='(')
				stack.push(i);
			else if(s.charAt(i)==')'){
				if(stack.isEmpty())	invalidIndex.add(i);
				else stack.pop();
			}
		}
		while (!stack.isEmpty())	invalidIndex.add(stack.pop());

		StringBuffer sbf = new StringBuffer();
		for (int i=0; i<s.length(); i++) {
			if (!invalidIndex.contains(i)) {
				sbf.append(s.charAt(i));
			}
		}

		return sbf.toString();
    }
	
	public static void main(String[] args) {		
		System.out.println(isValid("lee(t(c)o)de)"));
		System.out.println(isValid("a)b(c)d"));
		System.out.println(isValid("))(("));
	}
}