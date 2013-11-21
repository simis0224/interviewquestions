package Math;


public class IntegerToRoman {
	
	class Mapping {
		int integer;
		String roman;
		Mapping(int integer, String roman) {
			this.integer = integer;
			this.roman = roman;
		}
	}
	
    public String intToRoman(int num) {
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
    	
    	String result = "";
    	int baseIndex = mappings.length - 1;
    	int base = mappings[baseIndex].integer;
    	while(num != 0) {
    		if(num >= base) {
    			result += mappings[baseIndex];
    			num -= base;
    		} else {
    			baseIndex--;
    			base = mappings[baseIndex].integer;
    		}
    	}
    	
    	return result;
    }
}
