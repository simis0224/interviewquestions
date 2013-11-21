package Math;

/**
	Validate if a given string is numeric.
	
	Some examples:
	"0" => true
	" 0.1 " => true
	"abc" => false
	"1 a" => false
	"2e10" => true
	
	Note: It is intended for the problem statement to be ambiguous. 
	You should gather all requirements up front before implementing one.
 */
public class ValidNumber {
    public static boolean isNumber(String s) {
    	// empty string
    	if(s.trim().length() == 0) {
    		return false;
    	}
    	
    	// remove space in the front
    	int i = 0;
    	for(; i < s.length(); i++) {
    		if(s.charAt(i) != ' ') {
    			break;
    		}
    	}
    	
    	// check first char is a number or sign
    	if(!isNumberChar(s.charAt(i)) && !isSign(s.charAt(i)) && s.charAt(i) != '.') {
    		return false;
    	}
    	
    	if(isSign(s.charAt(i))) {
    		i++;
    	}
    	
    	if(i <s.length() && !isNumberChar(s.charAt(i)) && s.charAt(i) != '.') {
    		return false;
    	}
    	
    	boolean hasDot = false;
    	boolean hasE = false;
    	boolean hasSpace = false;
    	boolean hasSign = false;
    	int numCount = 0;
    	int numBeforeE = 0;
    	int numAfterE = 0;
    	int numAfterSign = 0;
    	for(; i < s.length(); i++) {
    		if(hasSpace && s.charAt(i) != ' ') {
    			return false;
    		}
    		
    		if(isSign(s.charAt(i))) {
    			if(!hasSign && hasE && s.charAt(i - 1) == 'e') {
    				hasSign = true;
    			} else {
    				return false;
    			}
    		} else if(s.charAt(i) == ' ') {
    			hasSpace = true;
    		} else if(s.charAt(i) == '.') {
    			if(hasE) {
    				return false;
    			}
    			if(!hasDot) {
    				hasDot = true;
    			} else {
    				return false;
    			}
    		}else if(s.charAt(i) == 'e') {
    			if(!hasE && numBeforeE > 0) {
    				hasE = true;
    			} else {
    				return false;
    			}
    		} else if(isNumberChar(s.charAt(i))) {
    			if(hasSpace) {
    				return false;
    			}
    			
        		numCount++;
        		if(hasE) {
        			numAfterE++;
        		} else {
        			numBeforeE++;
        		}
        		
        		if(hasSign) {
        			numAfterSign ++;
        		}
    		} else {
    			return false;
    		}
    	}
    	
    	if(hasE && numAfterE == 0) {
    		return false;
    	}
    	
    	if(hasSign && numAfterSign == 0) {
    		return false;
    	}
    	
    	return numCount > 0;
    }
    
    static boolean isSign(char c) {
    	return c == '+' || c == '-';
    }
    
    static boolean isNumberChar(char c) {
    	return c >= '0' && c <= '9';
    }
    
    public static void main(String[] args) {
    	isNumber(".34");
    }
}
