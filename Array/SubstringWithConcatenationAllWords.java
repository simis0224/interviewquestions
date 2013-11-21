package Array;


import java.util.ArrayList;
import java.util.HashMap;
/**
	You are given a string, S, and a list of words, L, that are all of the same length. 
	Find all starting indices of substring(s) in S that is a concatenation of each word in L 
	exactly once and without any intervening characters.
	
	For example, given:
	S: "barfoothefoobarman"
	L: ["foo", "bar"]
	
	You should return the indices: [0,9].
	(order does not matter).
 */
public class SubstringWithConcatenationAllWords {
	
	static ArrayList<Integer> result;
	static HashMap<String, Integer> words;
	static int wordLength = 0;
	
    public static ArrayList<Integer> findSubstring(String S, String[] L) {
    	result = new ArrayList<Integer>();
    	words = new HashMap<String, Integer>();
    	if(L.length == 0) {
    		return result;
    	}
    	
    	wordLength = L[0].length();
    	
    	for(int i = 0; i < L.length; i++) {
    		if(words.containsKey(L[i])) {
    			int count = words.get(L[i]);
    			words.put(L[i], count + 1);
    		} else {
    			words.put(L[i], 1);
    		}
    	}
    	
    	for(int i = 0; i < wordLength; i++) {
    		ArrayList<String> wordList = new ArrayList<String>();
    		for(int k = i; k + wordLength <= S.length(); k += wordLength) {
    			if(k + wordLength <= S.length()) {
    				wordList.add(S.substring(k, k + wordLength));
    			} 
    		}
    		
    		findSubstring(L, wordList, i);
    	}
    	
        return result;
    }
    
    public static void findSubstring(String[] L, ArrayList<String> wordList, int startIndex) {
		HashMap<String, Integer> visited = new HashMap<String, Integer>();
		int startWordIndex = 0;
		int wordCount = 0;;
		for(int k = 0; k < wordList.size(); k++) {
			String word = wordList.get(k);
			if(words.get(word) != null) {
				if(visited.get(word) != null && visited.get(word) >= words.get(word)) {
					for(int p = startWordIndex; p < k; p++) {
						int count = visited.get(wordList.get(p));
						visited.put(wordList.get(p), count - 1);
						wordCount --;
						if(wordList.get(p).equals(word)) {
							startWordIndex = p + 1;
							break;
						}
					}
				}
				if(visited.get(word) != null) {
					int count = visited.get(word);
					visited.put(word,  count + 1);
				} else {
					visited.put(word, 1);
				}
				wordCount++;
				
				if(wordCount == L.length) {
					result.add(startWordIndex * wordLength + startIndex);
					wordCount--;
					int count = visited.get(wordList.get(startWordIndex));
					visited.put(wordList.get(startWordIndex), count - 1);
					startWordIndex = startWordIndex + 1;
				} 
			} else {
				wordCount = 0;
				visited.clear();
				startWordIndex = k + 1;
			}
		}
    }
    
    public static void main(String[] args) {
    	findSubstring("abababab", new String[] {"a", "b", "a"});
    }
    
}
