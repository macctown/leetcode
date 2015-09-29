package leetcode;

public class FindMinInRSA {
	public static int findMin(int[] nums) {
        if(nums==null||nums.length==0){
        	return -1;
        }
        
        int lowerLimit = 0;
        int higherLimit = nums.length-1;
        while(lowerLimit+1<higherLimit){
        	int mid=lowerLimit+(higherLimit-lowerLimit)/2;
        	if(nums[mid]<nums[0]){
        		higherLimit = mid;
        	}
        	else{
        		lowerLimit = mid;
        	}
        }
        
        if(nums[0]<nums[higherLimit]){
        	return nums[0];
        }
        else{
        	return nums[higherLimit];
        }
    }
	
	public static void main(String args[]){
		int[] test = {2,3,4,5,1};
    	System.out.println(findMin(test));
	}
}
