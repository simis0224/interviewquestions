package String;

import java.util.Stack;

/**
	Given an absolute path for a file (Unix-style), simplify it.
	
	For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        
    	String result = "";
    	String[] tokens = path.trim().split("/");
    	Stack<String> stack = new Stack<String>();
    	int i = 0;
    	while(i < tokens.length) {
    		if(tokens[i].equals("..")) {
    			if(!stack.isEmpty()) {
    				stack.pop();
    			}
    		} else if(!tokens[i].equals(".") && tokens[i].length() > 0) {
    			stack.add(tokens[i]);
    		}
    		i++;
    	}
    	
    	while(!stack.isEmpty()) {
    		String token = stack.pop();
    		result = "/" + token + result;
    	}
    	
    	return result.length() == 0 ? "/" : result;
    }
    
    public static void main(String[] args) {
    	simplifyPath("/a/./b/../../c/");
    //	simplifyPath("/a/./b/../../c/");
    }
}
