package String;
import java.util.Stack;
/**
	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	
	The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class ValidParenthese {
    public static boolean isValid(String s) {
    	if(s.length()%2 == 1) {
    		return false;
    	}
    	
        Stack<Character> stack = new Stack<Character>();   
        for(int i = 0; i < s.length(); i++) {
        	if(isOpenParenthese(s.charAt(i))) {
        		stack.push(s.charAt(i));
        	} else {
        		if(stack.size() > 0) {
	        		char c = stack.peek();
	        		if(findOpenPair(s.charAt(i)) == c) {
	        			stack.pop();
	        		} else {
	        			return false;
	        		}
        		} else {
        			return false;
        		}
        	}
        }
        
        return stack.isEmpty();
    }
    
    public static boolean isOpenParenthese(char c) {
    	return c == '{' || c == '(' || c == '[';
    }
    
    public static char findOpenPair(char c) {
    	if(c == '}') {
    		return '{';
    	}
    	
    	if(c == ')') {
    		return '(';
    	}
    	
    	if(c == ']') {
    		return '[';
    	}
    	
    	return ' ';
    }
    
    public static void main(String [] args) {
    	isValid(")}{({))[{{[}");
    }
}
