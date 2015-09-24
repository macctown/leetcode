package leetcode;

import java.util.HashMap;

public class TwoSum {
		
	public static int[] twoSum2(int[] nums, int target) {
		int[] res = new int[2];
		if(nums==null || nums.length == 0){
        	return res;
        }
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(target-nums[i])){
				res[1] = i+1;
				res[0] = map.get(target-nums[i])+1;
				return res;
			}
			else{
				map.put(nums[i], i);
			}
		}

		
		return res;
    }
	
	
	
	public static void main(String args[]){
		int[] test1 = {2,1,9,4,4,56,90,3};
		int[] res = twoSum2(test1,8);
		for(int i=0;i<res.length;i++){
	    	  System.out.print(res[i]+" ");
		}
	}
}
