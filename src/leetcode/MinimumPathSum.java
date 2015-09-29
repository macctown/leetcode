package leetcode;

public class MinimumPathSum {
	public static int minPathSum(int[][] grid) {
		if(grid.length==0||grid==null){
        	return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        
        //initialize
        sum[0][0] = grid[0][0];
        for(int i=1;i<m;i++){
        	sum[i][0] = grid[i][0]+sum[i-1][0];
        }
        for(int i=1;i<n;i++){
        	sum[0][i] = grid[0][i]+sum[0][i-1];
        }
        
        
        for(int i=1;i<m;i++){
        	for(int j=1;j<n;j++){
        		sum[i][j] = Math.min(sum[i-1][j],sum[i][j-1])+grid[i][j];
        	}
        }
        
        return sum[m-1][n-1];
    }
	
	
	public static void main(String args[]){
		int[][] matrix = new int[2][2];
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		
		matrix[1][0] = 1;
		matrix[1][1] = 1;
		
		int[][] matrix2 = new int[1][1];
		matrix2[0][0]=1;
		
		
		System.out.println(minPathSum(matrix));
		System.out.println(minPathSum(matrix2));
	}
}
