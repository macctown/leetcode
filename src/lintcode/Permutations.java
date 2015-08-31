package lintcode;

import java.util.ArrayList;

public class Permutations {
	/**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> tmp = new ArrayList<Integer>();
    	
    	Find(nums, 0, res, tmp);
    	return res;
    }
    
    private static void Find(ArrayList<Integer> nums, int level, 
			ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp) {
    	//System.out.println(level);
    	if(nums.size()==level){
			res.add(new ArrayList<Integer> (tmp));
			return;
		}
		
		for(int i=level;i<nums.size();i++){
			tmp.add(nums.get(i));
			level++;       
			ArrayList<Integer> tmpNum =  new ArrayList<Integer>();
			tmpNum = nums;
			tmpNum.remove(i);
			//tmpNum.remove(i);
			Find(nums, level, res, tmp);
			tmp.remove(tmp.size()-1);
		}
	}

	public static void main(String args[]){
    	ArrayList<Integer> test = new ArrayList<Integer>();
    	test.add(1);
    	test.add(2);
    	test.add(3);
    	System.out.println(permute(test));
    }
}
