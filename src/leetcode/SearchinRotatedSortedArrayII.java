package leetcode;

public class SearchinRotatedSortedArrayII {
	public static boolean search(int[] nums, int target) {
        if(nums == null || nums.length==0){
        	return false;
        }
        
        int lowerLimit = 0;
        int higherLimit = nums.length-1;
        
        while(lowerLimit + 1<higherLimit){
        	int mid = lowerLimit + (higherLimit-lowerLimit)/2;
        	if(nums[mid]==target) return true;
        	if(nums[lowerLimit]==nums[mid]){
        		lowerLimit = mid+1;
        	}
        	else if(nums[lowerLimit]<nums[mid]){
        		if(nums[lowerLimit]<=target&&nums[mid]>target){
        			higherLimit = mid-1;
        		}
        		else{
        			lowerLimit = mid+1;
        		}
        	}
        	else if(nums[lowerLimit]>nums[mid]){
        		if(nums[higherLimit]<=target&&nums[mid]<target){
        			lowerLimit = mid+1;
        		}
        		else{
        			higherLimit = mid-1;
        		}
        	}
        	
        	
        }
        
        return false;
    }

	public static void main(String args[]){
		int[] arr1 = {1};
		System.out.println(search(arr1, 1));
	}
}
