package leetcode;

public class SearchinRotatedSortedArray {
	public static int search(int[] nums, int target) {
        if(nums.length==0||nums==null){
        	return -1;
        }
        
        int lowerLimit = 0;
        int higherLimit = nums.length-1;
        
        while(lowerLimit + 1 < higherLimit){
        	int mid = lowerLimit + (higherLimit - lowerLimit) / 2;
        	
        	if(nums[lowerLimit]<nums[mid]){
        		//higher part(left)
        		if(nums[lowerLimit]<=target&&target<=nums[mid]){
        			higherLimit = mid;
        		}
        		else{
        			lowerLimit = mid;
        		}
        	}
        	else{
        		//lower part(right)
        		if(nums[higherLimit]>=target&&target>=nums[mid]){
        			lowerLimit = mid;
        		}
        		else{
        			higherLimit = mid;
        		}
        	}
        }
        
        if(nums[lowerLimit]==target){
        	return lowerLimit;
        }
        else if(nums[higherLimit]==target){
        	return higherLimit;
        }
        else{
        	return -1;
        }
        
    }

	public static void main(String args[]){
		int[] arr1 = {4,5,6,7,0,1,2};
		System.out.println(search(arr1, 0));
	}
}
