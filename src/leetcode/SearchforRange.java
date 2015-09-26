package leetcode;

public class SearchforRange {
	public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if(nums==null||nums.length == 0){
        	res[0] = -1;
        	res[1] = -1;
        	return res;
        }
        
		int lowerLimit = 0;
        int higherLimit = nums.length-1;
        int mid = 0;
        while(lowerLimit+1<higherLimit){
        	mid = lowerLimit+(higherLimit-lowerLimit)/2;
        	if(nums[mid]<target){
        		lowerLimit = mid;
        	}
        	else if(nums[mid]>target){
        		higherLimit = mid;
        	}
        	else if(nums[mid]==target){
        		higherLimit = mid;
        	}
        }
        
        if(nums[lowerLimit] == target){
        	res[0] = lowerLimit;
        }
        else if(nums[higherLimit] == target){
        	res[0] = higherLimit;
        }
        else{
        	res[0] = -1;
        	res[1] = -1;
        	return res;
        }
        
        
        
        lowerLimit = 0;
        higherLimit = nums.length-1;
        mid = 0;
        while(lowerLimit+1<higherLimit){
        	mid = lowerLimit+(higherLimit-lowerLimit)/2;
        	if(nums[mid]<target){
        		lowerLimit = mid;
        	}
        	else if(nums[mid]>target){
        		higherLimit = mid;
        	}
        	else if(nums[mid]==target){
        		lowerLimit = mid;
        	}
        }
        
        if(nums[higherLimit] == target){
        	res[1] = higherLimit;
        }
        else if(nums[lowerLimit] == target){
        	res[1] = lowerLimit;
        }
        else{
        	res[0] = -1;
        	res[1] = -1;
        	return res;
        }
        
        return res;
    }
	
	public static void main(String args[]){
		int[] test = {1};
		int[] res = searchRange(test, 1);
		System.out.print(res[0]+" "+res[1]);
		
	
	}
}
