package leetcode;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if(nums==null||nums.length==0){
        	return -1;
        }
        
        int max = nums[0];
        int res = nums[0];
        
        for(int i=1;i<nums.length;i++){
            //max store new res or old res
        	max = Math.max(nums[i]+max, nums[i]);
        	
        	//res store the larger one
        	res = Math.max(res,max);
        }
        
        return res;
        
	}
}
