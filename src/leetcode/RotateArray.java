package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RotateArray {
	
	//1.queue, remove then add n times
	//TC: O(n)
	public static void rotate(int[] nums, int k) {
		if(nums==null||nums.length==0||k==0){
			return;
		}
		
        Queue<Integer> queue = new LinkedList();
        for(int i=nums.length-1;i>=0;i--){
        	queue.add(nums[i]);
        }
        
        //use peek and remove to pop a element and then add to top
        for(int j=0;j<k;j++){
        	int tmp = queue.peek();
        	queue.remove();
        	queue.add(tmp);
        }
        
        //NOTE: order of queue and array
        //array from back to beginning, queue is in the opposite order
        for(int n=nums.length-1;n>=0;n--){
        	int tmp = queue.peek();
        	queue.remove();
        	nums[n] = tmp;
        }
        
        for(int i=0;i<nums.length;i++){
	    	  System.out.print(nums[i]+" ");
		}
        System.out.println();
    }
	
	
	//2.use reverse method, reverse 1st part and second part the whole array
	//TC: O(n)
	public static void rotate2(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k==0){
			return;
		}
		int length = nums.length;
		//NOTE!!
		if(k>length){
			k = k % length;
		}
		reverse(nums, 0, length-k-1);
		reverse(nums, length-k, length-1);
		reverse(nums, 0, length-1);
		
		
		for(int i=0;i<nums.length;i++){
	    	  System.out.print(nums[i]+" ");
		}
		System.out.println();
	}
	
	public static void reverse(int[] nums, int start, int end){
		for(int i=start,k=end;i<=k;i++,k--){
			int tmp = nums[i];
			nums[i] = nums[k];
			nums[k] = tmp;
		}
	}
	
	public static void main(String args[]){
		int[] test1 = {};
		int[] test2 = {1,2,3,4,5,6,7};
		int[] test3 = {1,2};
		rotate2(test1, 0);
		rotate2(test2, 3);
		rotate2(test3, 3);
		
	}
}
