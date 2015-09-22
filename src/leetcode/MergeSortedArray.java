package leetcode;

public class MergeSortedArray {
	//pre-condition: nums1 has enough space
	
	
	//1.combine, then sort
	//TC: O(n)+O(sort)
	
	
	//2.put big in the back, loop all the array from back to start, then find who has left and add to res
	//TC: O(n)+O(k)
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
	       int total = m+n-1;
	       int len1 = m-1;
	       int len2 = n-1;
	       //two pointer move from back to start
	       while(len1>=0&&len2>=0){
	    	   //put the bigger one in the back
	    	   nums1[total--] = (nums1[len1] >= nums2[len2]) ? nums1[len1--] : nums2[len2--];
	    	   //minus one after use
	       }
	       
	       //check which array has elements left and add to nums1
	       if(len1>=0){
	    	   for(int i=len1;i>=0;i--){
	    		 //minus one after use
	    		   nums1[total--] = nums1[len1--];
	    	   }
	       }
	       else if(len2>=0){
	    	   for(int i=len2;i>=0;i--){
	    		 //minus one after use
	    		   nums1[total--] = nums2[len2--];
	    	   }
	       }
    	   
	       
	       for(int i=0;i<nums1.length;i++){
	    	  System.out.println(nums1[i]);
	       }
	}
	
	
	
	public static void main(String args[]){
		int[] arr1 = {1,2,3,0,0,0};
		int[] arr2 = {4,5,6};
		merge2(arr1, 3, arr2, 3);
	}
}
