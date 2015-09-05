package lintcode;

public class JumpGameII {
	 /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public static int jump(int[] A) {
        // write your code here
    	if(A == null || A.length ==0){
    		return 0;
    	}
    	
    	int start =0, end =0, jump =0;
    	while(end < A.length-1){
    		//break until it can get the dis larger than end index
    		jump++;	//number of jump++
    		int far = end;	//currently the farthest poi can reach
    		//loop from start to end to find the farthest poi can reach
    		for(int i=start;i<=end;i++){
    			if(A[i]+i>far){
    				far = A[i]+i;
    			}
    		}
    		start = end +1;	//??
    		end = far;	
    	}
    	return jump;
    }
    
    public static void main(String args[]){
    	int[] test = {2,3,1,1,4};
    	System.out.println(jump(test));
    }
}
