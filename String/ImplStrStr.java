package String;
/**
	Implement strStr().
	
	Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
	
	BBC ABCDAB ABCDABCDABDE
	
	ABCDABD
	0000120
	complexity O(n + k)
 */

public class ImplStrStr {
    public static String strStr(String haystack, String needle) {
        if(needle.length() == 0) {
        	return haystack;
        }
        
        int[] matchTable = buildMatchTable(needle);
        
        int haystackIndex = 0;
        int needleIndex = 0;
        while(needleIndex < needle.length() && haystackIndex < haystack.length()) {
        	if(needle.charAt(needleIndex) == haystack.charAt(haystackIndex)) {
        		needleIndex++;
        		haystackIndex++;
        	} else {
        		if(needleIndex > 0) {
        			needleIndex = matchTable[needleIndex - 1];
        		} else {
        			haystackIndex++;
        		}
        	}
        }
        if(needleIndex == needle.length()) {
        	return haystack.substring(haystackIndex - needleIndex);
        } else {
        	return null;
        }
    }
    
    public static int[] buildMatchTable(String needle) {
    	int[] matchTable = new int[needle.length()];
    	matchTable[0] = 0;
    	if(needle.length() > 1) {
    		int p = 1;
    		int k = 0;
    		while(p < needle.length()) {
    			if(needle.charAt(p) == needle.charAt(k)) {
    				matchTable[p] = k + 1;
    				p++;
    				k++;
    			} else if(k > 0){
    				k = matchTable[k - 1];
    			} else {
    				matchTable[p] = 0;
    				p++;
    			}
    		}
    	}
    	return matchTable;
    }
    
    public static void main(String[] args) {
    	buildMatchTable("aab");
    	strStr("bbaa", "aab");
    }
}
