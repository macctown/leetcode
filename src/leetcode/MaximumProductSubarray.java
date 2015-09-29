package leetcode;

public class MaximumProductSubarray {
	//TLE
	public static int maxProduct(int[] nums) {
        if(nums==null||nums.length==0){
        	return -1;
        }
        int m = nums.length;
        int max = 0;
        int[][] product = new int[m][m];
        
        //i*i+1*...*j
        for(int i=0;i<m-1;i++){
        	for(int j=i;j<m-1;j++){
        		if(i==j){
        			product[i][j] = nums[j];
        		}
        		else{
        			product[i][j] = product[i][j-1] * nums[j];
        		}
        		if(product[i][j]>max){
        			max = product[i][j];
        		}
        	}
        }
        
        return max;
    }
	
	
	//optimize
	public static int maxProduct2(int[] nums) {
        if(nums==null||nums.length==0){
        	return -1;
        }
        else if(nums.length==1){
        	return nums[0];
        }
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        
        for(int i=1;i<nums.length;i++){
        	int tmp = max;
        	max = Math.max(Math.max(max*nums[i], min*nums[i]),nums[i]);
        	min = Math.min(Math.min(tmp*nums[i], min*nums[i]),nums[i]);
        	
        	res = Math.max(res, max);
        }
        
        
        return res;
    }
	
	
	
	public static void main(String args[]){
		int[] test = {2,3,-2,4};
		System.out.println(maxProduct2(test));
	}
}
