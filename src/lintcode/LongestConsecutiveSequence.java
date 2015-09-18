package lintcode;

import java.util.HashSet;

public class LongestConsecutiveSequence {
	/**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        if(num.length == 0){
        	return 0;
        }
        if(num.length == 1){
        	return 1;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<num.length;i++){
        	set.add(num[i]);
        }
        
        int res = 0;
        for(int j=0;j<num.length;j++){
        	int tmp = 0;	//store tmp value of element+/-1
        	int length = 1;	//store the longest length
        	
        	//find consecutive larger than target
        	tmp = num[j]+1;
        	while(set.contains(tmp)){
        		set.remove(num[j]);
        		tmp++;
        		length++;
        	}
        	
        	//find consecutive less than target
        	tmp = num[j]-1;
        	while(set.contains(tmp)){
        		set.remove(num[j]);
        		tmp--;
        		length++;
        	}
        	
        	if(length>res){
        		res = length;
        	}
        	if(length>=num.length){
        		//optimization
        		break;
        	}
        }
        return res;
        
        
    }
    
    public static void main(String args[]){
    	
    }
}
