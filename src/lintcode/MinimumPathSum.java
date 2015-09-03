package lintcode;

public class MinimumPathSum {
	/**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public static int minPathSum(int[][] grid) {
        //set value of param
    	int m = grid.length;
    	int n = grid[0].length;
    	int[][] sum = new int[m][n];
    	
    	sum[0][0] = grid[0][0];
    	
    	//set value of first column
    	for(int i=1;i<m;i++){
    		sum[i][0] = sum[i-1][0] + grid[i][0];
    	}
    	
    	//set value of first row
    	for(int i=1;i<n;i++){
    		sum[0][i] = sum[0][i-1] + grid[0][i];
    	}
    	
    	//give sum to each element
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
    			sum[i][j] = Math.min(sum[i-1][j],sum[i][j-1]) + grid[i][j];
    		}
    	}
    	
    	return sum[m-1][n-1];
    	
    }
    
    public static void main(String args[]){
    	
    }
}
