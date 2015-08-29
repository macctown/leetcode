package lintcode;

public class BinarySearch {
	 /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public static int binarySearch(int[] nums, int target) {
        //write your code here
    	int lowerLimit = 0;
    	int higherLimit = nums.length-1;
    	while(lowerLimit<higherLimit){
    		int mid = lowerLimit + (higherLimit - lowerLimit)/2; //prevent hight+low overflow
    		if(target > nums[mid]){
    			lowerLimit = mid + 1; //prevent dead loop when search border element	
    		}
    		else if(target < nums[mid]){
    			higherLimit = mid - 1;
    		}
    		else{
    			higherLimit = mid;	//prevent duplicate number is the one in the mid
    		}
    		
    	}
    	
    	if(nums[lowerLimit] == target){
			return lowerLimit;
		}
		if(nums[higherLimit] == target){
			return higherLimit;
		}
    		
    	return -1; //if there's no target
    }
    
    public static int binarySearch2(int[] nums, int target){
    	 if (nums == null || nums.length == 0) {
             return -1;
         }
         
         int start = 0, end = nums.length - 1;
         while (start + 1 < end) {
             int mid = start + (end - start) / 2;
             if (nums[mid] == target) {
                 end = mid;  
             } else if (nums[mid] < target) {
                 start = mid;
             } else {
                 end = mid;
             }
         }
         if (nums[start] == target) {
             return start;
         }
         if (nums[end] == target) {
             return end;
         }
         return -1;
    }
    
    public static void main(String args[]){
    	int[] test = {0,1,5,8,8,10,23,43};
    	System.out.println(binarySearch(test, 8));
    }
}
