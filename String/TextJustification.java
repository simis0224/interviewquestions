package String;


import java.util.ArrayList;
/**
	Given an array of words and a length L, format the text such that each line has 
	exactly L characters and is fully (left and right) justified.
	
	You should pack your words in a greedy approach; that is, pack as many words as you can in 
	each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
	
	Extra spaces between words should be distributed as evenly as possible. If the number of spaces 
	on a line do not divide evenly between words, the empty slots on the left will be assigned more 
	spaces than the slots on the right.
	
	For the last line of text, it should be left justified and no extra space is inserted between words.
	
	For example,
	words: ["This", "is", "an", "example", "of", "text", "justification."]
	L: 16.
	
	Return the formatted lines as:
	
	[
	   "This    is    an",
	   "example  of text",
	   "justification.  "
	]
 */
public class TextJustification {
	
	static ArrayList<String> result;

    public static ArrayList<String> fullJustify(String[] words, int L) {
    	result = new ArrayList<String>();
    	
    	ArrayList<String> lineWord = new ArrayList<String>();
    	int lineWordLengthCount = 0;
    	for(int i = 0; i < words.length; i++) {
    		// for second word
			if(lineWord.size() > 0 && lineWordLengthCount + lineWord.size() - 1 + words[i].length() + 1 > L) {
				String line = "";
				if(lineWord.size() > 1) {
					int spaceLength = (L - lineWordLengthCount) / (lineWord.size() - 1);
					int bonusSpace = L - lineWordLengthCount - spaceLength * (lineWord.size() - 1);
					for(int j = 0; j < lineWord.size(); j++) {
						if(j > 0) {
							line += getSpaceString(spaceLength);
							if(bonusSpace > 0) {
								line += " ";
								bonusSpace--;
							}
						}
						line += lineWord.get(j);
					}
				} else {
					line = lineWord.get(0) + getSpaceString(L - lineWordLengthCount);
				}
				result.add(line);
				lineWord.clear();
				lineWordLengthCount = 0;
			} 
			
			lineWord.add(words[i]);
			lineWordLengthCount += words[i].length();
    	}
    	
    	//process last line
    	String line = "";
    	lineWordLengthCount = 0;
    	for(int i = 0; i <lineWord.size(); i++) {
    		if(i != 0) {
    			line += " ";
    		}
    		line += lineWord.get(i);
    		lineWordLengthCount += lineWord.get(i).length();
    	}
    	line += getSpaceString(L - lineWordLengthCount - (lineWord.size() - 1));
    	if(lineWord.size() > 0) {
    		result.add(line);
    	}
    	
    	return result;
    }
    
    public static String getSpaceString(int n) {
    	String space = "";
    	for(int i = 0; i < n; i++) {
    		space += " ";
    	}
    	return space;
    }
    
    public static void main(String [] args) {
    	fullJustify(new String[]{"a","b","c","d","e"}, 3);
    }
    
}
