package lintcode;

public class UniquePathsII {
	/**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	
    	if(m==0||n==0||obstacleGrid==null){
    		return 0;
    	}
    	
    	int[][] step = new int[m][n];
    	
    	//set value for the first column
    	//break when found obstacle, bcz the element in obstacle's right won't reach(cant move to leftside)
    	for(int i=0;i<m;i++){
    		if(obstacleGrid[i][0]!=1){
        		step[i][0] = 1;
    		}
    		else{
        		break;
    		}
    	}
    	
    	//set value for the first row
    	//break when found obstacle, bcz the element in obstacle's right won't reach(cant move to upside)
    	for(int i=0;i<n;i++){
    		if(obstacleGrid[0][i]!=1){
        		step[0][i] = 1;
    		}
    		else{
        		break;
    		}
    	}
    	
    	//calculate steps number in each step
    	//obstacle element set 0
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
    			if(obstacleGrid[i][j]!=1)
    			{	
    				step[i][j] = step[i-1][j] + step[i][j-1];
    			}
    			else{
    				step[i][j] = 0;
    			}
    		}
    	}
    	
    	return step[m-1][n-1];
    }
    
    public static void main(String args[]){
    	int[][] grid = new int[3][3];
    	grid[0][0] = 0;
    	grid[0][1] = 1;
    	grid[0][2] = 0;
    	
    	grid[1][0] = 0;
    	grid[1][1] = 0;
    	grid[1][2] = 0;
    	
    	grid[2][0] = 0;
    	grid[2][1] = 0;
    	grid[2][2] = 0;
    	
    	System.out.println(uniquePathsWithObstacles(grid));
    }
}
