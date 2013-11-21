package needVerification;

public class ValidNumber {
	
	public static boolean isValidNumber(String number) {
		if(number == null || number.length() == 0) {
			return false;
		}
		
		int i = 0;
		
		if(isSign(number.charAt(i))) {
			i++;
		}
		
		boolean hasDot = false;
		boolean hasInt = false;
		
		for(;i < number.length(); i++) {
			if(!hasInt && isNumber(number.charAt(i))) {
				hasInt = true;
			}
			
			if(!hasDot && isDot(number.charAt(i))) {
				if(hasInt) {
					hasDot = true;
					continue;
				} else {
					return false;
				}
			}
			
			
			if(isNumber(number.charAt(i))) {
				continue;
			}
			
			return false;
		}
		return hasInt;
	}
	
	
	public static boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}
	
	public static boolean isSign(char c) {
		return c == '-' || c == '+';
	}
	
	public static boolean isDot(char c) {
		return c == '.';
	}
	
	public static void main(String[] args) {
		boolean valid1 = isValidNumber("a772sb");
		boolean valid2 = isValidNumber("2000.00.11");
		boolean valid3 = isValidNumber("+77288.100");
		boolean valid4 = isValidNumber("+");
		boolean valid5 = isValidNumber("");
		boolean valid6 = isValidNumber("+.45");
		boolean valid7 = isValidNumber("45");
		boolean valid8 = isValidNumber("45.");
	}

}
