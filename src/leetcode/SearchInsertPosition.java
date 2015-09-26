package leetcode;

public class SearchInsertPosition {
	
	//use binary search, search the first element <= target
	public static int searchInsert(int[] nums, int target) {
		if(nums==null||nums.length == 0){
			return -1;
		}
        int lowerLimit = 0;
        int higherLimit = nums.length-1;
        int mid = 0;
        while(lowerLimit + 1 < higherLimit){
        	mid = (higherLimit-lowerLimit)/2+lowerLimit;
        	if(nums[mid]<target){
        		lowerLimit = mid;
        	}
        	else if(nums[mid]>target){
        		higherLimit = mid;
        	}
        	else{
        		return mid;
        	}
        }

        if(nums[lowerLimit]>=target){
        	return lowerLimit;
        }
        else if(nums[higherLimit]>=target){
        	return higherLimit;
        }
        else{
        	return higherLimit+1;
        }
        
    }
	
	
	public static void main(String args[]){
		int[] test = {1};
		System.out.println(searchInsert(test, 2));
		
		int[] test1 = {1,3,5,6};
		System.out.println(searchInsert(test1, 2));
		
		int[] test2 = {1,3,5,6};
		System.out.println(searchInsert(test2, 0));
	}
}
