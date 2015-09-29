package leetcode;

public class JumpGame {
	public static boolean canJump(int[] nums) {
        if(nums.length==0||nums==null){
        	return false;
        }
       
        boolean[] can = new boolean[nums.length];
        //initialize
        can[0] = true;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && j + nums[j] >= i) {
                    can[i] = true;
                    break;
                }
            }
        }
        
        return can[nums.length - 1];
    }
	
	public static void main(String args[]){
		
	}
}
