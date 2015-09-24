package leetcode;

public class RemoveDuplicatesfromSortedArray {
	
	//two poitner, same as: remove element
	public static int removeDuplicates(int[] nums) {
		//corner case
		if(nums==null || nums.length==0){
			return 0;
		}
        int newLength = 1;
        int cur = 1;
        int ele = nums[0];
        for(int i=1;i<nums.length;i++){
        	if(ele==nums[i]){
        		continue;
        	}
        	else{
        		nums[cur]=nums[i];
        		ele = nums[i];
        		cur++;
        		newLength++;
        	}
        }

        return newLength;
    }
	
	
	public static void main(String args[]){
		int[] test1 = {1,2,2,3,3,3,4};
		int[] test2 = {9,9};
		System.out.println(removeDuplicates(test1));                                                                          
	}
}
