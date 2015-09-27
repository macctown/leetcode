package leetcode;

public class FindPeakNumber {
	public static int findPeakElement(int[] nums) {
	       if(nums.length==0||nums==null){
	    	   return -1;
	       }
	       
	       int lowerLimit = 0;
	       int higherLimit = nums.length-1;
	       
	       //divide into different situation
	       while(lowerLimit + 1<higherLimit){
	    	   int mid = lowerLimit+(higherLimit-lowerLimit)/2;
	    	   if(nums[mid]>nums[mid+1]&&nums[mid]>nums[mid-1]){
	    		   return mid;
	    	   }
	    	   else if(nums[mid]>nums[mid+1]){
	    		   higherLimit = mid;
	    	   }
	    	   else if(nums[mid]<nums[mid+1]&&nums[mid]<nums[mid-1]){
	    		   higherLimit = mid;
	    	   }
	    	   else if(nums[mid]<nums[mid+1]){
	    		   lowerLimit = mid;
	    	   }
	    	   
	       }
	       
	       //the bigger one is the peak
	      if(nums[lowerLimit]<nums[higherLimit]){
	    	  return higherLimit;
	      }
	      else{
	    	  return lowerLimit;
	      }
	      
    }
	
	
	public static void main(String args[]){
    	int[] test = {1, 2,3,4,5,7,6};
    	System.out.println(findPeakElement(test));
    }
}
