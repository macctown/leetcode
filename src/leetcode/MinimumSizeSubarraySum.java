package leetcode;

public class MinimumSizeSubarraySum {
	public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0||nums==null){
        	return 0;
        }
        int start=0;
        int end=0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(start<=end&&end<nums.length&&sum<s){
        	sum = sum+nums[end];
        	while(start<=end&&sum>=s){
        		res = Math.min(res, end-start+1);
        		sum = sum - nums[start];
        		start++;
        	}
        	end++;
        }
        return res!=Integer.MAX_VALUE?res:0; 
    }
	
	public static void main(String args[]){
		int[] test = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, test));
		
	}
}
