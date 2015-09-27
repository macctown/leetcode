package leetcode;

public class RemoveDuplicateII {
	public static int removeDuplicates(int[] nums) {
        if(nums==null){
        	return 0;
        }
        
        if(nums.length<=2){
        	return nums.length;
        }
        
        
        int cur =1;
        //nums[i]=nums[cur]=nums[cur-1], just compare nums[i] and nums[cur-1], skip the one in the middle
        for(int i=2;i<nums.length;i++){
        	if(nums[i]!=nums[cur-1]){
        		cur++;
        		nums[cur]=nums[i];
        	}
        }
        
        return cur+1;
        
    }
	
	public static void main(String args[]){
		int[] test1 = {1,1,1,1};
		System.out.println(removeDuplicates(test1));
	}
}
