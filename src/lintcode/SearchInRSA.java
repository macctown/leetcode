package lintcode;

public class SearchInRSA {
	/** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public static int search(int[] A, int target) {
        // write your code here
    	if(A.length==0){
    		return -1;
    	}
    	
    	int poi = -1;
    	int lowerLimit = 0;
    	int higherLimit = A.length-1;
    	
    	while(lowerLimit+1<higherLimit){
    		int mid = lowerLimit + (higherLimit - lowerLimit) / 2;
    		if(A[lowerLimit] < A[mid]){
    			//left part(higher position in xy)
    			//lowerLimit is border
    			if(A[mid] >= target && A[lowerLimit] <= target){
    				higherLimit = mid;
    			}
    			else{
    				lowerLimit = mid;
    			}
    		}
    		else{
    			//right part(lower position in xy)
    			//higherLimit is border
    			if(A[mid] <= target && A[higherLimit] >= target){
    				lowerLimit = mid;
    			}
    			else{
    				higherLimit = mid;
    			}
    		}
    		
    	}
    	
    	if(A[lowerLimit]==target){
    		poi = lowerLimit;
    	}
    	else if(A[higherLimit]==target){
    		poi = higherLimit;
    	}
    	return poi;
    	
    }
    
    public static void main(String args[]){
    	int[] test = {4,5,1,2,3};
    	System.out.println(search(test,1));
    }
}
