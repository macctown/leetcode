package leetcode;

public class MultiplyStrings {
	
	public static String multiply(String num1, String num2) {
		StringBuilder res = new StringBuilder();
		if(num1.length()==0&&num2.length()==0){
        	return res.toString();
        }
		
		String rNum1 = new StringBuilder(num1).reverse().toString();
		String rNum2 = new StringBuilder(num2).reverse().toString();
		int length1 = num1.length();
		int length2 = num2.length();
		int[] numRes = new int[length1+length2];
		
		for(int i=0; i<length1 ; i++){
			for(int j=0; j<length2 ; j++){
				//minus '0' to get the real number in a efficient way, not need to use charToint method
				numRes[i+j] += (rNum1.charAt(i)-'0') * (rNum2.charAt(j)-'0');
			}
		}
		
		
		for(int i=0;i<numRes.length-1;i++){
			int forward = numRes[i]/10;
			numRes[i]= numRes[i]%10;

			numRes[i+1] +=forward;
			
			res.insert(0, numRes[i]);
		}
		
		res.insert(0, numRes[numRes.length-1]);
		
		//delete the 0 in the front, but ensure there's at least one 0 left
		while(res.charAt(0)=='0'&&res.length()>1){
			res.deleteCharAt(0);
		}
		
		return res.toString();
    }
	
	public static void main(String args[]){
		System.out.println(multiply("5","23"));
		String test = "0";
		if(test.equals("0")){
			System.out.println("yes");
		}
	}
}
