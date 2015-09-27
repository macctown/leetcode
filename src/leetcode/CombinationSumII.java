package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	 public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		 List<List<Integer>> res = new ArrayList<List<Integer>>();
		 if(candidates.length==0||candidates==null){
			 return res;
		 }
		 List<Integer> tmp = new ArrayList<Integer>();
		 Arrays.sort(candidates);
		 combination_helper(candidates, target, 0, res, tmp);
		 for(int i=0;i<res.size();i++){
	        	for(int j=0;j<res.get(i).size();j++){
	        		System.out.print(" "+res.get(i).get(j));
	        	}
	        	System.out.println();
	        }
		 return res;
	 }

	private static void combination_helper(int[] candidates, int target, int start,
			List<List<Integer>> res, List<Integer> tmp) {
		if(target<0){
			return;
		}
		
		//when get to target, add to res, but check duplicate first
		if(target==0){
			if(!res.contains(new ArrayList<Integer>(tmp)))
				res.add(new ArrayList<Integer>(tmp));
			return;
		}
		
		for(int i=start;i<candidates.length;i++){
			tmp.add(candidates[i]);
			int newTarget = target - candidates[i];
			combination_helper(candidates, newTarget, i+1, res, tmp);
			tmp.remove(tmp.size()-1);
		}
		
	}
	
	public static void main(String args[]){
		int[] test = {10,1,2,7,6,1,5};
		combinationSum2(test, 8);
	}
	 
	 
}
