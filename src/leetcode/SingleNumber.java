package leetcode;

public class SingleNumber {
	//use bitwise
	public int singleNumber(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
        	res = res^nums[i];
        }
        return res;	
    }
	
	//use hashmap to store num and its count
	//or use hashset, if get false after add, it means duplicate
}
