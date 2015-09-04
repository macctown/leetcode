package lintcode;

public class ClimbStairs {
	/**
     * @param n: An integer
     * @return: An integer
     */
    public static int climbStairs(int n) {
        // write your code here
    	if(n <= 1){
    		return 0;
    	}
    	
    	int[] step = new int[n];
    	step[0] = 1;
    	step[1] = 2;
    	
    	for(int i=2;i<n;i++){
    		step[i] = step[i-1] + step[i-2];
    	}
    	
    	return step[n-1];
    }
    
    public static void main(String args[]){
    	System.out.println(climbStairs(3));
    }
}
