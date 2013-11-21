package Math;
/**
	Given two numbers represented as strings, return multiplication of the numbers as a string.
	
	Note: The numbers can be arbitrarily large and are non-negative.
 */

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
    	String sum = "";
    	String base = "";
        for(int i = num2.length() - 1; i >= 0; i--) {
        	String mult = multiplySingleNumber(num1, num2.charAt(i) - '0');
        	if(!"0".equals(mult)) {
        		mult = mult + base;
        	}
        	sum = addTwoNumbers(sum, mult);
        	base = base + "0";
        }
        
        for(int i = 0; i < sum.length(); i++) {
        	if(sum.charAt(i) != '0') {
        		return sum.substring(i);
        	}
        }
        return "0";
    }
    
    public static String multiplySingleNumber(String num, int k) {
    	int carry = 0;
    	String result = "";
    	int i = num.length() - 1;
    	while(i >= 0 || carry != 0) {
    		int n = 0;
    		if(i >= 0) {
    			n = num.charAt(i) - '0';
    			i--;
    		}
    		int mul = n * k + carry;
    		result = (mul % 10) + result;
    		// carry = 0 if mul < 10;
    		if(mul >= 10) {
    			carry = mul / 10;
    		} else {
    			carry = 0;
    		}
    	}
    	return result;
    }
    
    public static String addTwoNumbers(String num1, String num2) {
    	int carry = 0;
    	String result = "";
    	int i = num1.length() - 1, j = num2.length() - 1;
    	while(i >= 0 || j >= 0 || carry != 0) {
    		int n1 = 0;
    		if(i >= 0) {
    			n1 = num1.charAt(i) - '0';
    			i--;
    		}
    		int n2 = 0;
    		if(j >= 0) {
    			n2 = num2.charAt(j) - '0';
    			j--;
    		}
    		int sum = n1 + n2 + carry;
    		result = sum % 10 + result;
    		if(sum >= 10) {
    			carry = sum / 10;
    		} else {
    			carry = 0;
    		}
    	}		
    	return result;
    }
    
    /*
    public static String multiplySingleNumber(String num, int k, int carry) {
    	// don't forget carry == 0
    	if(num.length() == 0 && carry == 0) {
    		return "";
    	}
    	
    	int mul = 0;
    	int n = 0;
    	String nextNum = "";
    	if(num.length() > 0) {
    		n = (num.charAt(num.length() - 1) - '0') * k;
    		nextNum = num.substring(0, num.length() - 1);
    	} else {
    		mul = carry;
    	}
    	mul = n + carry;
    	if(mul >= 10) {
    		carry = mul / 10;
    	} else {
    		carry = 0;
    	}
    	String nextNumber = multiplySingleNumber(nextNum, k, carry);
    	if("0".equals(nextNumber)) {
    		return "" + mul%10;
    	} else {
    		return multiplySingleNumber(nextNum, k, carry) + mul%10;
    	}
    }
    
    
    public static String addTwoNumbers(String num1, String num2, int carry) {
    	// don't forget carry == 0
    	if(num1.length() == 0 && num2.length() == 0 && carry == 0) {
    		return "";
    	}
    	
    	int n1 = 0;
    	String newNum1 = "";
    	if(num1.length() > 0) {
    		n1 = num1.charAt(num1.length() - 1) - '0';
    		newNum1 = num1.substring(0, num1.length() - 1);
    	}
    	int n2 = 0;
    	String newNum2 = "";
    	if(num2.length() > 0) {
    		n2 = num2.charAt(num2.length() - 1) - '0';
    		newNum2 = num2.substring(0, num2.length() - 1);
    	}
    	int sum = n1 + n2 + carry;
    	if(sum >= 10) {
    		carry = sum / 10;
    	} else {
    		carry = 0;
    	}
    	
    	return addTwoNumbers(newNum1, newNum2, carry) + (sum % 10);
    }*/
    
    public static void main(String[] args) {
    	multiply("9133", "0");
    }
    

}
