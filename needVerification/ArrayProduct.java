package needVerification;

public class ArrayProduct {
    public static int[] randomNumber(int[] num) {
        if(num == null) {
             return null;
        }
    
        int[] result = new int[num.length];
        if(num.length == 1) {
            result[0] = 0;
        }
       
        int[] leftProduct = new int[num.length];
        int[] rightProduct = new int[num.length];
       
        leftProduct[0] = 1;
        rightProduct[num.length - 1] = 1;
        for(int i = 1; i < num.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * num[i - 1];
        }
       
        for(int i = num.length - 2; i >=0; i--) {
            rightProduct[i] = rightProduct[i + 1] * num[i + 1];
        }
       
        for(int i = 0; i < num.length; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }
       
        return result;   
    }
    
    public static void main(String[] args) {
    	randomNumber(new int[]{3, 4, 5});
    }
}
