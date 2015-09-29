package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class ThreeSum {
	//use loop, and two pointer: start(from i+1) and end(from length-1)   
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length; i++){
             
            //avoid duplicate solutions
            if(i == 0 || nums[i] > nums[i-1]){
                int target = -nums[i];
                int left = i + 1;
                int right = nums.length-1;
                while(left < right){
                    if(nums[left] + nums[right] < target){
                        left++;
                    }
                    else if(nums[left] + nums[right] > target){
                        right--;
                    }
                    else{
                        ArrayList<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        ret.add(l);
                        left++;
                        right--;
                         
                        //avoid duplicate solutions
                        while(left < right && nums[left] == nums[left-1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }
                }
            }
        }
        return ret;

    }
	
	public static List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums==null||nums.length==0){
			return res;
		}
		List<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length-2;i++){
			//i==0 here is to avoid i-1 when i=0
			if(i==0||nums[i]>nums[i-1]){
				int left = i+1;
				int right = nums.length-1;
				while(left<right){
					int sum = nums[left]+nums[right]+nums[i];
					if(sum<0){
						left++;
					}
					else if(sum>0){
						right--;
					}
					else{
						//note: the order here
						tmp.add(nums[i]);
						tmp.add(nums[left]);
						tmp.add(nums[right]);
						res.add(tmp);
						left++;
						right--;
						//skip the same elements
						while(left<right&&nums[left]==nums[left-1]){
							left++;
						}
						while(left<right&&nums[right]==nums[right+1]){
							right--;
						}
					}
				}
				
				
			}
		}
		
		return res;
	}
	

	public static void main(String args[]){
		int[] test1 = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		List<List<Integer>> res = threeSum2(test1);
		for(int i=0;i<res.size();i++){
	    	  for(int j=0;j<res.get(i).size();j++){
	    		  System.out.print(" "+res.get(i).get(j));
	    	  }
	    	  System.out.println();
		}
	}
}
