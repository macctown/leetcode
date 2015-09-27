package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates.length==0 || candidates==null){
        	return res;
        }
        List<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        
        combine_help(candidates, target, tmp, res, 0);
        
        for(int i=0;i<res.size();i++){
        	for(int j=0;j<res.get(i).size();j++){
        		System.out.print(" "+res.get(i).get(j));
        	}
        	System.out.println();
        }
        
        return res;
    }

	private static void combine_help(int[] candidates, int target, List<Integer> tmp,
			List<List<Integer>> res, int start) {
		if(target < 0){
			return;
		}
		if(target == 0){
			if(!res.contains(new ArrayList<Integer>(tmp)))
				res.add(new ArrayList<Integer>(tmp));
			return;
		}
		
		for(int i =start;i<candidates.length;i++){
			//avoid duplicate 
			if(i>0&&candidates[i]==candidates[i-1]){
				continue;
			}
			tmp.add(candidates[i]);
			int newTarget = target - candidates[i];
			//you can choose duplicate element here, "i" means you can choose the same one
			combine_help(candidates, newTarget, tmp, res, i);
			tmp.remove(tmp.size()-1);
		}
		
		
	}
	
	public static void main(String args[]){
		int[] test = {10,1,2,7,6,1,5};
		combinationSum(test, 8);
	}
}
