package Math;

/**
	Given a roman numeral, convert it to an integer.
	
	Input is guaranteed to be within the range from 1 to 3999.
 */

public class RomanToInteger {
	
	class Mapping {
		int integer;
		String roman;
		Mapping(int integer, String roman) {
			this.integer = integer;
			this.roman = roman;
		}
	}
	
    public int romanToInt(String s) {
    	Mapping[] mappings = new Mapping[] {
    			new Mapping(1, "I"),
    			new Mapping(4, "IV"),
    			new Mapping(5, "V"),
    			new Mapping(9, "IX"),
    			new Mapping(10, "X"),
    			new Mapping(40, "XL"),
    			new Mapping(50, "L"),
    			new Mapping(90, "XC"),
    			new Mapping(100, "C"),
    			new Mapping(400, "CD"),
    			new Mapping(500, "D"),
    			new Mapping(900, "CM"),
    			new Mapping(1000, "M")
    	};
    	
    	int result = 0;
    	int baseIndex = mappings.length - 1;
    	while(s.length() > 0) {
    		if(s.startsWith(mappings[baseIndex].roman)) {
    			result += mappings[baseIndex].integer;
    			s = s.substring(mappings[baseIndex].roman.length());
    		} else {
    			baseIndex--;
    		}
    	}
    	
    	return result;
    }
}
