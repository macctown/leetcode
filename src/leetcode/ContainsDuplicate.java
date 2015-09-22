package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {
	
	//1. use hashmap store num and its times of appear
	//TC: O(n)
	public boolean containsDuplicate(int[] nums) {
		//corner case
        if(nums.length==0||nums==null){
        	return false;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length-1;
        while(len>=0){
        	int count = 0;
        	if(!map.containsKey(nums[len])){
        		map.put(nums[len--], count);
        	}
        	else{
        		return true;
        	}
        }
        return false;
    }
	
	
	//use hashset's feature, return false after add duplicate element
	public static boolean containsDuplicate2(int[] nums) {
		//corner case
        if(nums.length==0||nums==null){
        	return false;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        int len = nums.length-1;
        while(len>=0){
        	boolean flag = set.add(nums[len--]);
        	if(flag==false){
        		return true;
        	}
        }
        return false;
	}
	
	public static void main(String args[]){
		int[] test1 = {};
		int[] test2 = {1,2,5,4,5};
		int[] test3 = {1,1};
		System.out.println(containsDuplicate2(test1));
		System.out.println(containsDuplicate2(test2));
		System.out.println(containsDuplicate2(test3));
	}


}
