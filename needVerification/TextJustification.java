package needVerification;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	
	public static ArrayList<String> fullJustify(String[] words, int L) {
		
		ArrayList<String> result = new ArrayList<String>();
		
		int i = 0;
		int curWordsLength = 0;
		List<String> curLineWords = new ArrayList<String>();
		while(i < words.length) {
			if(curWordsLength + curLineWords.size() - 1 + words[i].length() + 1 > L) {
				String line = "";
				// curLineWords size == 1 case
				int intervalLength = curLineWords.size() > 1 ? (L - curWordsLength) / (curLineWords.size() - 1) : 0;
				int extraSpaces = L - curWordsLength - intervalLength * (curLineWords.size() - 1);
				for(int j = 0; j < curLineWords.size(); j++) {
					String space = "";
					if(j < curLineWords.size() - 1) {
						space = getSpaces(intervalLength);
						if(extraSpaces > 0) {
							space += " ";
							extraSpaces--;
						}
					}
					line += curLineWords.get(j) + space;
				}
				line += getSpaces(L - line.length());
				result.add(line);
				curWordsLength = 0;
				curLineWords.clear();
			} 
			curWordsLength += words[i].length();
			curLineWords.add(words[i]);
			// don't forget i++
			i++;
		}
		
		if(curLineWords.size() > 0) {
			String line = "";
			for(int j = 0; j < curLineWords.size(); j++) {
				line += curLineWords.get(j);
				if(j < curLineWords.size() - 1) {
					line += " ";
				}
			}
			line += getSpaces(L - line.length());
			result.add(line);
		}
		return result;
	}
	
	public static String getSpaces(int n) {
		String space = "";
		for(int i = 0; i < n; i++) {
			space += " ";
		}
		return space;
	}
	
	public static void main(String[] args) {
		fullJustify(new String[] {"a", "b", "c", "d", "e"}, 1) ;
	}
}
