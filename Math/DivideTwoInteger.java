package Math;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * @author qlu
 *
 */
public class DivideTwoInteger {
    public static int divide(int dividend, int divisor) {
    	// don't forget sign. divisor or dividend could be negative
    	long tmpDivisor = Math.abs((long)divisor);
    	long tmpDividend = Math.abs((long)dividend);
    	int result = 0;
    	long p = 0;
    	
    	if(tmpDivisor <= tmpDividend) {
	    	long newDivisor = tmpDivisor;
	    	while(true) {
	    		if(p == 0) {
	    			p = 1;
	    		} else {
	    			p = p << 1;
	    		}
	    		tmpDivisor = newDivisor;
	    		newDivisor = newDivisor << 1;
	    		if(newDivisor > tmpDividend) {
	    			break;
	    		}
	    	}
    	}
    	
    	// don't forget k > 0
    	result += p;
    	
    	tmpDividend = tmpDividend - tmpDivisor;
    	
    	// don't forget abs
    	while(tmpDividend >= Math.abs((long)divisor)) {
	    	
    		while(tmpDivisor > tmpDividend) {
    			tmpDivisor = tmpDivisor >> 1;
    			p = p >> 1;
    		}
    		
	    	result += p;
	    	
	    	tmpDividend = tmpDividend - tmpDivisor;
    	}
    	
    	if(dividend <0 && divisor >0 || dividend > 0 && divisor <0) {
    		return 0 - result;
    	}
        return result;
    }
    
    public static void main(String[] args) {
    	divide(2147483647, 1);
    }
}
