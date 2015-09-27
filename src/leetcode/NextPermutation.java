package leetcode;

public class NextPermutation {
	 public static void nextPermutation(int[] nums) {
	        if(nums.length==0||nums==null){
	        	return;
	        }
	        
	        //1.find the first small one
	        //2.find the first one bigger than the small one 
	        //3.swap
	        //4.reverse after the index of small one
	        int partition = -1;
	        int par_index = -1;
	        
	        int larger = Integer.MAX_VALUE;
	        int lar_index = -1;
	        for(int i=nums.length-1;i>=1;i--){
	        	if(nums[i-1]<nums[i]){
	        		partition = nums[i-1];
	        		par_index = i-1;
	        		break;
	        	}
	        }
	        
	        
	        if(partition == -1){
	        	 //means the permutation is the largest now
	        	reverse(nums, par_index+1);
	        	return;
	        }
	        else{
	        	for(int j=nums.length-1;j>par_index;j--){
		        	if(nums[j]>partition){
		        		if(nums[j]<larger){
		        			larger = nums[j];
		        			lar_index = j; 	//change j only when the value change 
		        		}
		        		
		        	}
		        }
	        	int tmp = nums[par_index];
		        nums[par_index] = nums[lar_index];
		        nums[lar_index] = tmp;
	        }
	        
	        
	        
	        reverse(nums, par_index+1);

	        return;
	        
	 }
	 
	 private static void reverse(int[] nums, int start) {
		// TODO Auto-generated method stub
		for(int i=start,j=nums.length-1;i<j;i++,j--){  
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
	}

	public static void main(String args[]){
		 int[] test = {1,2};
		 nextPermutation(test);
	 }
}
