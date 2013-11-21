package Math;

/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */

public class AddBinary {

	public static String addBinary(String s1, String s2) {
		return addBinary(s1, s2, 0);
	}

	public static String addBinary(String s1, String s2, int carry) {
		//!!! carry must be 0 too
		if(s1.length() == 0 && s2.length() == 0 && carry == 0) {
			return "";
		}
		
		int num1 = 0;
		if(s1.length() > 0) {
			num1 = Integer.valueOf(s1.charAt(s1.length() - 1) - '0');
			s1 =  s1.substring(0, s1.length() - 1);
		}
		
		int num2 = 0;
		if(s2.length() > 0) {
			num2 = Integer.valueOf(s2.charAt(s2.length() - 1) - '0');
			s2 =  s2.substring(0, s2.length() - 1);
		}
		
		int sum = num1 + num2 + carry;
		carry = sum >= 2 ? 1 : 0; 
		return "" + addBinary(s1, s2, carry) + "" + sum%2;
	}
	
    
    public static void main(String [] args) {
    	addBinary("1", "1");
    }
}
