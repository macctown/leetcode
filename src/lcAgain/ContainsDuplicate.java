package lcAgain;

import java.util.HashSet;

public class ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
        
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<nums.length; i++){
            if(!set.add(nums[i])){
                return false;
            }
            else{
                set.add(nums[i]);
            }
        }
        
        return false;
    }
	
	public static void main(String args[]){
		int[] test1 = {};
		int[] test2 = {1,2,5,4,5};
		int[] test3 = {1,1};
		System.out.println(containsDuplicate(test2));
	}
}
