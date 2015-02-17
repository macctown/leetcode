package leetcode;

public class PlusOne {
	/*
	 * Given a non-negative number represented as an array of digits, 
	 * plus one to the number.
	 * The digits are stored such that the most significant digit is at the head of the list.
	 */
	
	public static void main(String[] args)
	{
		int[] testArray = {9};
		System.out.println("Origin Array of PlusOne: ");
		for(int a : testArray){
			System.out.println(a+" ");
		}
		
		testArray = plus(testArray);
		System.out.println("Result of PlusOne: ");
		for(int a : testArray){
			System.out.println(a+" ");
		}
	}
	
	public static int[] plus(int[] digits){
		
		for(int i=digits.length-1;i>=0;i--){
			int res = (digits[i]+1)%10;
			if(res==0){
				//说明有进位
				digits[i] = res;
				if(i==0){
					int[] newdigit = new int[digits.length+1];
					newdigit[0] = 1;
					return newdigit;
				}
			}else{
				digits[i] = res;
				break;
			}
		}
		return digits;
	}
}
