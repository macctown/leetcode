package lcAgain;

import java.util.HashSet;

public class HappyNumber {
	public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        
        int tmp = n;
        while(tmp!=1){
        	int sum = 0;
            while(tmp!=0){
                int digit = tmp%10;
                sum += digit * digit;
                tmp = tmp/10;
            }
            boolean flag = set.add(sum);
            if(!flag){
                return false;
            }
            else{
                tmp = sum;
                sum = 0;
            }
        }
        
        return true;
    }
	
	
	public static void main(String args[]){
		System.out.println(isHappy(19));
	}
}
