package lcAgain;

import java.util.LinkedList;

public class RotateArray {
	 public static void rotate(int[] nums, int k) {
	        LinkedList<Integer> queue = new LinkedList<Integer>();
	        
	        for(int i=nums.length-1;i>=0;i--){
	            queue.add(nums[i]);
	        }
	        
	        for(int j=0;j<k;j++){
	            int tmp = queue.peek();
	            queue.poll();
	            queue.add(tmp);
	        }
	        
	        for(int i=0;i<nums.length;i++){
	        	nums[i] = queue.get(nums.length-i-1);
	        }
	        
	        for(int i=0;i<nums.length;i++){
	        	System.out.print(" "+nums[i]);
	        }
	    }
	 
	 
	 public static void rotate2(int[] nums, int k) {
	        k = k%nums.length;
	        if(nums.length == 0|| nums.length == 1){
	            return;
	        }
	        nums = reverse(nums, 0, nums.length-k-1);
	        nums = reverse(nums, nums.length-k, nums.length-1);
	        nums = reverse(nums, 0, nums.length-1);
	        
	        for(int i=0;i<nums.length;i++){
	        	System.out.print(" "+nums[i]);
	        }
	    }
	    
	    public static int[] reverse(int[] nums, int beg, int end){
	        for(int i=beg, j=end;i<j;i++,j--){
	            int temp = nums[i];
	            nums[i] = nums[j];
	            nums[j] = temp;
	        }
	        return nums;
	    }
	 
	 
	 public static void main(String args[]){
		 int[] test = {1,2};
		 rotate2(test,3);
	 }
}
