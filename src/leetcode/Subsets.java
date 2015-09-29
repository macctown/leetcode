package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length==0||nums==null){
			return res;
		}
		Arrays.sort(nums);
		List<Integer> tmp = new ArrayList<Integer>();
		subset_helper(nums, 0, res, tmp);
		
		return res;
    }
	
	private static void subset_helper(int[] nums, int level,
			List<List<Integer>> res, List<Integer> tmp) {
		// TODO Auto-generated method stub
		if(level == nums.length){
			//when it get up-limit, return
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		//left
		subset_helper(nums, level+1, res, tmp);
		
		//right
		tmp.add(nums[level]);
		subset_helper(nums, level+1, res, tmp);
		//remove and add others
		tmp.remove(tmp.size()-1);

	}

	public static void main(String args[]){
		int[] test = {1,2,3};
    	System.out.println(subsets(test));
	}
}	
