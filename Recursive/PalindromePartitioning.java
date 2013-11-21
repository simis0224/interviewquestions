package Recursive;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
	Given a string s, partition s such that every substring of the partition is a palindrome.
	
	Return all possible palindrome partitioning of s.
	
	For example, given s = "aab",
	Return
	
	  [
	    ["aa","b"],
	    ["a","a","b"]
	  ]
 */
public class PalindromePartitioning {
	
	static Map<String, ArrayList<ArrayList<String>>> cache;
	
    public static ArrayList<ArrayList<String>> partition(String s) {
        cache = new HashMap<String, ArrayList<ArrayList<String>>>();
        
        return doPartition(s);
    }
    
    public static ArrayList<ArrayList<String>> doPartition(String s) {
    	
    	if(cache.containsKey(s)) {
    		return copyList(cache.get(s));
    	}
    	
    	ArrayList<ArrayList<String>> resultLists = new ArrayList<ArrayList<String>>();
    	if(s.length() == 1) {
    		resultLists = new ArrayList<ArrayList<String>>();
    		ArrayList<String> result = new ArrayList<String>();
    		result.add(s);
    		resultLists.add(result);
    		cache.put(s, copyList(resultLists));
    		return resultLists;
    	}
    	
    	for(int i = 1; i <= s.length(); i++) {
    		String newString = s.substring(0, i);
    		if(isPalindrome(newString)) {
    			// more palindrome
    			if(s.substring(i).length() > 0) {
    				ArrayList<ArrayList<String>> nextStringResult = doPartition(s.substring(i));
	    			for(ArrayList<String> list : nextStringResult) {
	    				list.add(0, newString);
	    				resultLists.add(list);
	    			}
    			} else {
    				// no more palindrome
    				ArrayList<String> result = new ArrayList<String>();
    				result.add(newString);
    				resultLists.add(result);
    			}
    		}
    	}
    	
    	cache.put(s, copyList(resultLists));
    	
    	return resultLists;
    }
    
    static boolean isPalindrome(String s) {
    	int p = 0;
    	int q = s.length() - 1;
    	while(p < q) {
    		if(s.charAt(p) != s.charAt(q)) {
    			return false;
    		}
    		p++;
    		q--;
    	}
    	return true;
    }
    
    static ArrayList<ArrayList<String>> copyList(ArrayList<ArrayList<String>> lists) {
    	ArrayList<ArrayList<String>> copiedList = new ArrayList<ArrayList<String>>();
    	for(ArrayList<String> list : lists) {
    		ArrayList<String> newList = new ArrayList<String>();
    		for(String string : list) {
    			newList.add(string);
    		}
    		copiedList.add(newList);
    	}
    	return copiedList;
    }
    
    public static void main(String[] args) {
    	partition("dde");
    }
    
}
