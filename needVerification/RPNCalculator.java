package needVerification;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RPNCalculator {
    public static double rpn(List<String> ops) throws Exception {
        Stack<Double> stack = new Stack<Double>();
        
        for(int i = 0; i < ops.size(); i++) {
            if(!isOperator(ops.get(i))) {
                stack.push(Double.valueOf(ops.get(i)));
            } else if(isOperator(ops.get(i))){
                double num1 = 0;
                double num2 = 0;
                if(!stack.isEmpty()) {
                    num1 = stack.pop();
                } else {
                	throw new Exception();
                }
                
                if(!stack.isEmpty()) {
                    num2 = stack.pop();
                } else {
                	throw new Exception();
                }
                
                // should reserve num2 and num1
                double result = doMath(num2, num1, ops.get(i));
                stack.push(result);
            } else {
                throw new Exception("Invalid input");
            }   
        }
        
        if(!stack.isEmpty()) {
            return stack.pop();
        } else {
            throw new Exception("Stack cannot b");
        }
    }
    
    private static boolean isOperator(String op) {
        return "+".equals(op) || "-".equals(op) || "*".equals(op) || "/".equals(op);
    }
    
    private static double doMath(double num1, double num2, String op) throws Exception {
        if("+".equals(op)) {
            return num1 + num2;
        } else if("-".equals(op)) {
            return num1 - num2;
        } else if("*".equals(op)) {
            return num1 * num2;
        } else if("/".equals(op)) {
            return num1 / num2;
        } else {
            throw new Exception("Invalid operation");
        }
    }
    
    public static void main(String[] args) throws Exception {
    	List<String> list= new ArrayList<String>();
    	list.add("4");
    	list.add("7");
    	list.add("+");
    	list.add("8");
    	list.add("/");
    	rpn(list);
    }
}
