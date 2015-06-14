package leetcode;

public class RotateArray {
	public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        if(n>k){
	        int[] replace = new int[n];
	        int m=0;
	        for(int i=n-k,j=0;;i++,j++){
	        	System.out.println("i: "+i);
	        	System.out.println("j: "+j);
	        	System.out.println("m: "+m);
	        	if(i<n){
	        		replace[j] = nums[i];
	        	}
	        	else if(m<n-k){
	        		replace[j] =nums[m]; 
	        		m++;
	        	}
	        	else if(m==n-k){
	        		break;
	        	}
	        }
	        
	        for(int i=0;i<n;i++){
	        	nums[i]=replace[i];
	        }
        }
    }
	
	public static void rotate2(int[] nums, int k) {
		if(k>0){
			k--;
			int n = nums.length;
        	int last = nums[n-1];
            while(n>1){
            	nums[n-1] = nums[n-2];
            	n--;
            }
            nums[0]=last;
            rotate(nums,k);
		}
    }
	
	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		if(n>=2){
			k=k%n;
			reverse(nums, 0, n-1);
			reverse(nums, 0, k-1);
			reverse(nums, k, n-1);
		}
    }
	
	public static void reverse(int[] nums, int s, int e){
		System.out.println("s: "+s+" e: "+e);
		for(;s<e;s++,e--){
			//use ^ to alternate a to b without extra variable
			nums[s]^=nums[e];
			nums[e]^=nums[s];
			nums[s]^=nums[e];
			for(int i=0;i<nums.length;i++){
				System.out.print(nums[i]+" ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args){
		int[] test = {1,2};
		rotate(test,3);
		for(int i=0;i<test.length;i++){
			System.out.print(test[i]+" ");
		}
	}
}
