package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII {
	public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k==0){
        	return res;
        }
        int[] candidates = new int[10];
        for(int i=0;i<9;i++){
        	candidates[i] = i+1;
        }
        
        List<Integer> tmp = new ArrayList<Integer>();
        combination_helper(candidates, n, k, tmp, res, 0);
        
        for(int i=0;i<res.size();i++){
        	for(int j=0;j<res.get(i).size();j++){
        		System.out.print(" "+res.get(i).get(j));
        	}
        	System.out.println();
        }
        
        return res;
    }

	private static void combination_helper(int[] candidates, int target, int limit,
			List<Integer> tmp, List<List<Integer>> res, int start) {
		// TODO Auto-generated method stub
		
		if(target <0){
			return;
		}
		if(tmp.size()>limit){
			return;
		}
		if(target == 0){
			if(!res.contains(new ArrayList<Integer>(tmp))&&tmp.size()==limit)
			{
				res.add(new ArrayList<Integer>(tmp));
			}
			return;
		}
		
		for(int i=start;i<candidates.length;i++){
			if(i>0&&candidates[i]==candidates[i-1]){
				continue;
			}
			tmp.add(candidates[i]);
			int newTarget = target - candidates[i];
			combination_helper(candidates, newTarget, limit, tmp, res, i+1);
			tmp.remove(tmp.size()-1);
		}
		
		
		
	}
	
	public static void main(String args[]){
		combinationSum3(3, 9);
	}
}
