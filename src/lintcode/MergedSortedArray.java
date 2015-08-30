package lintcode;

public class MergedSortedArray {
	/**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
    	int total = m+n;
    	for(int i=0;i<n;i++){
    		A[m+i] = B[i];	//bind two array together
    	}
    	
    	//sort new array
    	for(int j=0;j<total;j++){
    		for(int k=0;k<total;k++){
    			if(A[j]<A[k]){
    				//swap
    				int tmp = A[j];
    				A[j] = A[k];
    				A[k] = tmp;
    			}
    		}
    	}
    }
    
    public static void mergeSortedArray2(int[] A, int m, int[] B, int n){
    	//two pointer
    	
    }
    
    public static void main(String args[]){
    	int[] array1 = new int[10];
    	array1[0] = 1;
    	array1[1] = 5;
    	array1[2] = 10;
    	
    	int[] array2 = new int[2];
    	array2[0] = 4;
    	array2[1] = 6;
    	
    	mergeSortedArray(array1, 3 , array2, 2);
    	for(int i=0;i<array1.length;i++){
    		System.out.println(array1[i]);
    	}
    }
}
