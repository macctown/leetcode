package leetcode;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0){
        	return 0;
        }
        
        //res[i][j] means the largest length of square which bottom right is [i][j]
        int[][] res = new int[matrix.length][matrix[0].length];
        int max = 0;
        //initialize
        for(int i=0;i<matrix.length;i++){
        	res[i][0] = matrix[i][0] - '0';
        	if(res[i][0] == 1) max = 1;
        }
        
        for(int j=0;j<matrix[0].length;j++){
        	res[0][j] = matrix[0][j] - '0';
        	if(res[0][j] == 1) max = 1;
        }
        
        for(int i=1;i<matrix.length;i++){
        	for(int j=1;j<matrix[0].length;j++){
        		if(matrix[i][j]=='0'){
        			res[i][j]=0;
        		}
        		if(matrix[i][j]=='1'){
        			res[i][j] = Math.max(Math.max(res[i-1][j], res[i-1][j-1]), res[i][j-1])+1;
            		max = Math.max(res[i][j], max);
        		}
        	}
        }
        
        return max*max;
    }
}
