package leetcode;

public class FindDuplicateNumber {	
	public int findDuplicate(int[] nums) {
        if(nums.length==0||nums==null){
        	return -1;
        }
        
        int fast=nums[0],slow=nums[0];
        do{
        	fast = nums[nums[fast]];
        	slow = nums[slow];
        }while(nums[slow]!=nums[fast]);
        
        slow = nums[0];
        while(slow!=fast){
        	fast = nums[nums[fast]];
        	slow = nums[slow];
        }
        
        return fast;
    }
	
	//binary search to find the elements have more counts
	public int findDuplicate2(int[] nums) {
        if(nums.length==0||nums==null){
        	return -1;
        }
        
        
        
        
        
        
    }
	
	public static void main(String args[]){
		
	}
}
