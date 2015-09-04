package lintcode;

public class UniquePaths {
	/**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public static int uniquePaths(int m, int n) {
        // write your code here 
    	if(m==0||n==0){
    		return 0;
    	}
    	
    	int[][] step = new int[m][n];
    	
    	//set value for the first column
    	for(int i=0;i<m;i++){
    		step[i][0] = 1;
    	}
    	
    	//set value for the first row
    	for(int i=0;i<n;i++){
    		step[0][i] = 1;
    	}
    	
    	//calculate steps number in each step
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
    			step[i][j] = step[i-1][j] + step[i][j-1];
    		}
    	}
    	
    	return step[m-1][n-1];
    }
    
    public static void main(String args[]){
    	
    }
}
