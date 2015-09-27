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
	
		//two poitner, continue when same, when it's differ, just move end and give end the differ value 
		public static int removeDuplicates2(int[] nums) {
			//corner case
			if(nums==null || nums.length==0){
				return 0;
			}
			int cur = 0;
			for(int i=1;i<nums.length;i++){
				if(nums[i]!=nums[cur]){
					cur++;
					nums[cur] = nums[i];
				}
			}

	        return cur+1;
	    }
	
	
	
	
	public static void main(String args[]){
		int[] test1 = {1,2,2,3,3,3,4};
		int[] test2 = {9,9};
		System.out.println(removeDuplicates2(test1));                                                                          
	}
}
