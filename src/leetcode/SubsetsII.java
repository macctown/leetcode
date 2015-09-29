package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length==0||nums==null){
        	return res;
        }
		
		Arrays.sort(nums);	//ensure the result set is sorted
		List<Integer> tmp = new ArrayList<Integer>();
		subsets_helper(nums, 0, res ,tmp);
		
		return res;
    }
	
	
	private static void subsets_helper(int[] nums, int level,
			List<List<Integer>> res, List<Integer> tmp) {
		// TODO Auto-generated method stub
		if(level==nums.length){
			//avoid duplicate sub-res
			if(!res.contains(new ArrayList<Integer>(tmp)))
				res.add(new ArrayList<Integer>(tmp));
			return;
		}
		
		subsets_helper(nums, level+1, res, tmp);
		tmp.add(nums[level]);
		subsets_helper(nums, level+1, res, tmp);
		tmp.remove(tmp.size()-1);
	}


	public static void main(String args[]){
		int[] test = {1,2,2};
    	System.out.println(subsetsWithDup(test));
	}
}
