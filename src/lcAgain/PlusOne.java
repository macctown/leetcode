package lcAgain;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i]>=0 && digits[i]<9){
                digits[i]++;
                return digits;
            }
            else if(i!=0){
                digits[i]=0;
            }
            else{
                int[] newDigits = new int[digits.length+1];
                newDigits[0] = 1;
                for(int j=1;j<newDigits.length;j++){
                    newDigits[j] = 0;
                }
                
                return newDigits;
            }
        }
        
        return digits;
    }
}
