package leetcode;

import java.util.HashMap;

public class ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++)
    	{
    		if(map.containsKey(nums[i]))
    		{
    			return true;
    		}
    		else{
    			map.put(nums[i], i);
    		}
    	}
		return false;
    }
	
	public static void main(String[] args){
		System.out.println("123");
		int[] nums={3,5,1,2,4,4};
		System.out.println(containsDuplicate(nums));
	}
}
