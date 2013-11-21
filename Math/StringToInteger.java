package Math;


public class StringToInteger {
    public static int atoi(String str) {
    	if(str.length() == 0) {
    		return 0;
    	}
    	
    	// remove space in the front
    	int p = 0;
    	while(str.length() > 0 && str.charAt(p) == ' ') {
    		p++;
    	}
    	str = str.substring(p);
    	
    	// check sign
        boolean isNegative = false;
        if(isSign(str.charAt(0))) {
	        if(str.charAt(0) == '-') {
	        	isNegative = true;
	        }
	        str = str.substring(1);
        }
        
        // add number. break the loop when first char is not number
        int result = 0;
        while(str.length() > 0 && isDigit(str.charAt(0)) ) {
        	// don't forget result > 214748364 as the next number would be >= 2147483650
        	if(result == 214748364 && str.charAt(0) > '7' || result > 214748364)
        		return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        	else {
        		result = result * 10 + str.charAt(0) - '0';
        	}

        	str = str.substring(1);
        }
        
        return isNegative ?  (0 - result) : result;
    }
    
    public static boolean isDigit(char c) {
    	return c >= '0' && c <= '9';
    }
    
    public static boolean isSign(char c) {
    	return c == '+' || c == '-';
    }
    
    public static void main(String[] args) {
    	atoi("      -11919730356x");
    }
}
