package Recursive;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
	Given a string containing only digits, restore it by returning all possible valid IP address combinations.
	
	For example:
	Given "25525511135",
	
	return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

public class RestoreIPAddress {
	
	public static ArrayList<String> restoreIpAddresses(String s) {
		cached = new HashMap<String, ArrayList<String>>();
		restoreIpAddresses(4, s);
		if (cached.get(s + "4") != null) {
			return cached.get(s + "4");
		} else {
			return new ArrayList<String>();
		}
	}
	
	public static Map<String, ArrayList<String>> cached;
	
	public static ArrayList<String> restoreIpAddresses(int index, String s1) {
		
		if(cached.containsKey(s1 + "" + index)) {
			return cached.get(s1 + "" + index);
		}
		
		if(index == 0) {
			if(s1.length() == 0) {
				return new ArrayList<String>();
			} else {
				return null;
			}
		} else {
			if(s1.length() == 0) {
				return null;
			}
		} 
		
		ArrayList<String> results = new ArrayList<String>();
		for(int i = 1; i <=3 && i <= s1.length(); i++) {
			String numStr = s1.substring(0, i);
			if(Integer.valueOf(numStr) <= 255 && 
					Integer.valueOf(numStr).toString().length() == numStr.length()) {
				String nextS = s1.substring(i);
				ArrayList<String> returnResults = restoreIpAddresses(index - 1, nextS);
				if(returnResults != null) {
					if(returnResults.size() == 0 && index == 1) {
							results.add(numStr);
					} else if(returnResults.size() > 0){
						int resultSize = returnResults.size();
						for(int k = 0; k < resultSize; k++) {
							results.add(numStr + "." + returnResults.get(k));
						}
					}
				}
			}
		}
		cached.put(s1 + "" + index, results);
		
		return results;
	}
	
    public static void main(String [] args) {
    	restoreIpAddresses("25525511135");
    }
	
	/**
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> results = new ArrayList<String>();
        restoreIpAddresses(0, "", s, results);
        return results;
    }
    
    public void restoreIpAddresses(int index, String s1, String s2, ArrayList<String> results) {
    	
    	if(index == 0 && s1.length() > 3*4) {
    		return;
    	}
    	
    	// next index = 4
    	if(index == 4 && s2.length() == 0) {
    		results.add(s1);
    		return;
    	}
    	
    	
    	for(int i = 1; i <= Math.min(3, s2.length()); i++) {
    		String number = s2.substring(0, i);
    		// number <= 255 && number doesn't have any zero in the front
    		if(Integer.valueOf(number) <= 255 && 
    				number.length() == Integer.valueOf(number).toString().length()) {
    			restoreIpAddresses(index + 1, s1 + (s1.length() != 0 ? "." : "") + number, s2.substring(i), results);
    		}
    	}
    }
    **/
}
