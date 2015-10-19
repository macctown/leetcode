package leetcode;

public class HouseRobberII {
	public int rob(int[] nums) {
		if(nums.length == 0 || nums==null){
        	return 0;
        }
        if(nums.length == 1){
        	return nums[0];
        }
        if(nums.length == 2){
        	return Math.max(nums[0], nums[1]);
        	
        }
        
        //divide into 2 situation: contain element[0] and not contain element[0]
        return Math.max(robHelper(nums, 0, nums.length-2), robHelper(nums, 1, nums.length-1));
    }

	private int robHelper(int[] nums, int start, int end) {
		// TODO Auto-generated method stub
			int newLen = end-start+1;
        	if(newLen==1) return nums[start]; 
		 	int res[] = new int[newLen];
	        res[0] = nums[start];
	        res[1] = Math.max(nums[start], nums[start+1]);
	        
	        for(int i=2;i<newLen;i++){
	        	res[i] = Math.max(res[i-1], res[i-2]+nums[start+i]);
	        }
	        
	        
	      return res[newLen-1];
	}
}
