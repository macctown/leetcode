package lintcode;

public class FindPeakElement {
	/**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public static int findPeak(int[] A) {
        // write your code here
    	int poi = 0;
    	for(int i=0;i<A.length-1;i++){
    		if((A[i]-A[i+1])>0){
    			poi = i;	//find the rotated position 
    		}
    	}
    	return poi;
    }
    
    public static int findPeak2(int[] A){
    	int lowerLimit = 1;
    	int higherLimit = A.length-2;
    	
    	while(lowerLimit+1<higherLimit){
    		int mid = lowerLimit + (higherLimit - lowerLimit) / 2;
    		if(A[mid]<A[mid-1]){
    			higherLimit = mid;
    		}
    		else if(A[mid]>A[mid-1]){
    			lowerLimit = mid;
    		}
    		else{
    			higherLimit = mid; 
    		}
    	}
    	if(A[lowerLimit]<A[higherLimit]){
    		return higherLimit;
    	}
    	else{
    		return lowerLimit;
    	}
    	
    }
    
    
    public static void main(String args[]){
    	int[] test = {1, 2, 1, 3, 4, 5, 7, 6};
    	System.out.println(findPeak(test));
    }
}
