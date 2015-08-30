package lintcode;

public class MedianOfTwoRSA {
	/**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public static double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
    	int[] totalArray = new int[A.length+B.length];
    	for(int i=0;i<B.length;i++){
    		if(A[i]<=B[i]){
    			totalArray[i] = A[i];
    		}
    		else{
    			totalArray[i] = B[i];
    		}
    	}
    	
    	for(int j=i;)
    }
    
    
    
    public static void main(String args[]){
    	int[] testA = {1,2,3,4,5,6};
    	int[] testB = {2,3,4,5};
    	
    	System.out.println(findMedianSortedArrays(testA, testB));
    }
}
