package leetcode;

import java.util.HashSet;

public class HappyNumber {
	//if it's a happy number, the last res must be 1
	//if there's loop of another number, return false
	public static boolean isHappy(int n) {
        if(n == 0){
        	return false;
        }
       HashSet<Integer> set = new HashSet<Integer>();
       
        while(n!=1){
        	int sum = 0;
        	while(n!=0){
        		int mod = n%10;
        		sum += mod*mod;
        		n = n/10;
        	}
        	if(set.contains(sum)){
        		return false;
        	}
        	else{
        		set.add(sum);
        		n = sum;
        	}
        }
        
        return true;
    }
	
	
	
	
	public static void main(String args[]){
		
	}
}
