package leetcode;

public class UniquePathsII {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0||obstacleGrid==null){
        	return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        //initialize
        int[][] step = new int[m+1][n+1];
        
        for(int i=0;i<m;i++){
        	if(obstacleGrid[i][0]==1){
        		break;
        	}
        	else{
        		step[i][0] = 1;
        	}
        }
        
        for(int i=0;i<n;i++){
        	if(obstacleGrid[0][i]==1){
        		break;
        	}
        	else{
        		step[0][i] = 1;
        	}
        }
        
        
        for(int i=1;i<m;i++){
        	for(int j=1;j<n;j++){
        		if(obstacleGrid[i][j]!=1){
        			//if not obstacle, just go
            		step[i][j] = step[i-1][j] + step[i][j-1];
        		}
        		else{
        			//counter obstacle, make it 0
        			step[i][j] = 0;
        		}
        		
        	}
        }
        
        return step[m-1][n-1];
    }
	
	public static void main(String args[]){
		int[][] matrix = new int[3][3];
		matrix[0][0] = 0;
		matrix[0][1] = 0;
		matrix[0][2] = 0;
		
		matrix[1][0] = 0;
		matrix[1][1] = 1;
		matrix[1][2] = 0;
		
		matrix[2][0] = 0;
		matrix[2][1] = 0;
		matrix[2][2] = 0;
		
		System.out.println(uniquePathsWithObstacles(matrix));
		
	
	}
}
