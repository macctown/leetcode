package leetcode;

public class RemoveElement {
	//use two pointers
	//delete duplicate elements and change array, make it every elements left connect to each other
	//TC: O(n)
	public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int newLength = 0;
        int cur = 0;		//pointer to record new position for elements
        for(int i=0;i<length;i++){
        	if(nums[i]!=val){
        		//if it's not target, put it into array in new order
        		nums[cur] = nums[i];
        		cur++;		//move pointer
        		newLength++;
        	}
        }
        
        return newLength;
    }
	
	public static void main(String args[]){
		int[] test1 = {1,2,7,9,2,5,1};
		int[] test2 = {9,9};
		System.out.println(removeElement(test1, 2));
		
		
	}
}
