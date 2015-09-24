package leetcode;

import java.util.HashMap;

public class SortColors {
	public static void sortColors(int[] nums) {
		//corner case
		if(nums==null||nums.length==0){
            return;
        }
		
		int start = 0;
		int end = nums.length-1;
        for(int i=0;i<nums.length;){
        	if(nums[i]==0){
        		//swap 0 from back to front
        		int tmp = nums[i];
        		nums[i] = nums[start];
        		nums[start] = tmp;
        		start++;
        		//bcz the element we swap from front to end won't be 2, so we could go forward to next
        		i++;
        		continue;
        	}
        	else if(nums[i]==2){
        		//if i point or exceed pointer [end], then it means it has been the area of 2, then stop
        		 if(i>= end){
                     break;
                 }
        		 //swap 2 from front to back
        		int tmp = nums[i];
        		nums[i] = nums[end];
        		nums[end] = tmp;
        		end --;
        		//bcz we don't know what element will put forward. so we can't change i
        		//we need to stay on i and check it(eg. 2 swap with 2)
        		continue;
        	}
        	//if it's one, just check the next one
    		i++;
        	
        }
        
        for(int i=0;i<nums.length;i++){
	    	  System.out.print(nums[i]+" ");
		}
        
        
    }
	
	
	public static void main(String args[]){
		int[] test1 = {2,0};
		sortColors(test1);
	}
}
