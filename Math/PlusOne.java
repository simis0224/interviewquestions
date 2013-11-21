package Math;


import java.util.Stack;

/**
	Given a number represented as an array of digits, plus one to the number.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
    	Stack<Integer> result = new Stack<Integer>();
    	plusOne(digits, result, digits.length - 1, 1);
    	int[] resultArray = new int[result.size()];
    	for(int i = 0; i < resultArray.length; i++) {
    		resultArray[i] = result.pop();
    	}
        return resultArray;
    }
    
    public void plusOne(int[] digits, Stack<Integer> result, int index, int carry) {
    	if(index < 0 && carry == 0) {
    		return;
    	}
    	
    	int sum = (index >= 0 ? digits[index] : 0) + carry;
    	carry = sum >= 10 ? 1 : 0;
    	// don't need to use stack actually, just add element to the beginning of array list
    	result.add(sum%10);
    	plusOne(digits, result, index - 1, carry);
    }
}
