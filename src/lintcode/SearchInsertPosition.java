package lintcode;

public class SearchInsertPosition {
	/** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public static int searchInsert(int[] A, int target) {
        // write your code here
    	int res = 0;
    	if(A.length==0||A==null){
    		return 0;
    	}
    	if(target<A[0]){
			res = 0;
			return res;
		}
		if(target>A[A.length-1]){
			res = A.length;
			return res;
		}
		
    	for(int i=0;i<A.length;i++){
    		if(A[i]==target){
    			res = i;
    			break;
    		}
    		if(i>0&&i<A.length-1){
	    		if(A[i-1]<target&&A[i+1]>target){
	    			res = i+1;
	    			break;
	    		}
    		}		
    	}
    	
    	
    	return res;
    }
    
    public static void main(String args[]){
    	int[] test = {1,3,5,6,8,9};
    	System.out.println(searchInsert(test,7));
    }
}
