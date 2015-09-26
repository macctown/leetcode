package leetcode;

public class PlusOne {
	
	//use loop to check every digit from end to beginning
	//TC: O(n)
	public static int[] plusOne(int[] digits) {
		//corner case
        if(digits==null || digits.length==0){
        	return digits;
        }
        
        //loop from last to beginning, check if it's 9
		for(int i=digits.length-1;i>=0;i--){
        	if(digits[i]<9&&digits[i]>=0){
        		//between 0-8, just add 1 and return 
        		digits[i]++;
        		return digits;
        	}
        	else if(i!=0){
        		//9, but not in the beginning, change it to 0 and continue to check next digit
        		digits[i] = 0;
        	}
        	else{
        		//9, but it's the first one of array, that means the num is like 99 or 999
        		//create a new length+1 array, and put first digit 1 and rest of digits 0
        		int[] newDigits = new int[digits.length+1];
        		newDigits[0] = 1;
        		for(int j=1;j<newDigits.length-1;j++){
        			newDigits[j] = 0;
        		}
        		return newDigits;
        	}
        }
        
        return digits;
    }
	
	
	public static void main(String args[]){
		int[] test = {1,2,5};
		int[] test2 = {9,9};
		int[] res1 = plusOne(test);
		int[] res2 = plusOne(test2);
		
		for(int i=0;i<res1.length;i++){
	    	  System.out.println(res1[i]);
	    }
		for(int i=0;i<res2.length;i++){
	    	  System.out.println(res2[i]);
		}
	}
}
