package String;
import java.util.Stack;

/**
	Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
	parentheses substring.
	
	For "(()", the longest valid parentheses substring is "()", which has length = 2.
	
	Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
    	int max = 0;
    	int[] t = new int[s.length()];
    	
    	Stack<Pair> stack = new Stack<Pair>();
        
    	for(int i = 0; i < s.length(); i++) {
    		t[i] = 0;
    		if(s.charAt(i) == '(') {
    			stack.push(new Pair('(', i));
    		} else {
    			if(stack.size() > 0 && stack.peek().parenthese == '(') {
    				Pair p = stack.pop();
    				for(int j = i; j >= p.index; j--) {
    					t[j] = 1;
    				}
    			} else {
    				stack.push(new Pair(')', i));
    			}
    		}
    	}
    	
    	int tmp = 0;
    	for(int i = 0; i < t.length; i++) {
    		if(t[i] == 1) {
    			tmp ++;
    			max = Math.max(tmp, max);
    		} else {
    			tmp = 0;
    		}
    	}
    	
        return max;
    }
    
    public static class Pair {
    	int index;
    	char parenthese;
    	public Pair(char parenthese, int index) {
    		this.index = index;
    		this.parenthese = parenthese;
    	}
    }
    
}