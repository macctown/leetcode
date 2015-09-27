package leetcode;

public class ProductofArrayExceptSelf {
	public static int[] productExceptSelf(int[] nums) {
        if(nums==null){
        	return null;
        }
        
        int[] res = new int[nums.length];
        //calculate left part, 0~i-1
        res[0] = 1;
        for(int i=1;i<nums.length;i++){
        	res[i] = res[i-1] * nums[i-1];
        }
        
      //calculate right part, i+1~n-1
        int tmp =1;
        for(int i=nums.length-1;i>=0;i--){
        	res[i] = res[i]*tmp;
        	tmp = tmp*nums[i];
        }
        
        return res;
    }
	
	public static void main(String args[]){
		
	}
}
