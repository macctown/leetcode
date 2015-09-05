package lintcode;

public class JumpGame {
	/**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public static boolean canJump(int[] A) {
        // write your code here
    	//Greedy
    	if(A==null||A.length==0){
    		return false;
    	}
    	
    	//The max distance it can reach now
    	int far = A[0];
    	
    	//from second element to last
    	for(int i=1;i<A.length;i++){
    		if(i<=far && A[i]+i>=far){
    			//current poi need to be less than far poi
    			//cur poi plus the step it can jump need to bigger than far
    			far = A[i] + i;
    		}
    	}
    	
    	if(far >= A.length-1){
    		return true;
    	}
    	else{
    		return false;
    	}
    	
    }
    
    
    public static void main(String args[]){
    	int[] test = {2,0,1,0,4};
    	System.out.println(canJump(test));
    }
}
