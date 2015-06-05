package leetcode;

import java.util.HashMap;
import java.util.Set;

public class ContainsDuplicateII {
	public static boolean containsDuplicateII(int[] nums,int k) {
		if(nums.length < 2 || k == 0) return false;

	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();

	    for(int i = 0; i < nums.length; i++) {
	    	if(map.containsKey(nums[i])){
	    		int index = map.get(nums[i]);
	    		if(Math.abs(index-i)<=k){
	    			return true;
	    		}
	    	}
	    	map.put(nums[i], i);
	    }
	    
	    return false;
    }
	
	public static void main(String[] args){
		int[] nums={1,2,1};
		System.out.println(containsDuplicateII(nums,1));
		//containsDuplicateII(nums,1);
	}
}
