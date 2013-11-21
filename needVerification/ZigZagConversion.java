package needVerification;

public class ZigZagConversion {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int nCols = s.length() / nRows;
    	if(s.length() % nRows > 0) {
    		nCols++;
    	}
    	
    	char[][] newS = new char[nRows][nCols];
    	
        
    }
}
