package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length==0){
        	return 0;
        }
        Arrays.sort(nums);
        int sub = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0;i<nums.length;i++){
        		int left = i+1;	//the number behind nums[i]
        		int right = nums.length-1;	//end of array
        		
        		//move pointers "left" and "right" between left&right
        		while(left<right){
	        		int sum = nums[i]+nums[left]+nums[right];
	        		
	        		//record min sub
	        		if(Math.abs(sum-target)<sub){
	        			sub = Math.abs(sum-target);
	        			res = sum;
	        		}
	        		//move pointer according to comparasion of target and sum
	        		if(target>sum){
	        			left++;
	        		}
	        		else if(target<sum){
	        			right--;
	        		}
	        		else{
	        			return target;
	        		}
        		}
        }
        return res;

    }


	public static void main(String args[]){
		int[] test = {-1,2,1,-4};
		System.out.println(threeSumClosest(test, 1));
	}
}
