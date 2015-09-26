package leetcode;

public class SetMatrixZeroes {
	//TC: O(m*n)
	public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        if(m==0|| n==0){
        	return;
        }
        
        int[] fRow =new int[m];
        int[] fCol =new int[n];
        
        //set flag to sign which row and column is 0
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(matrix[i][j]==0){
        			fRow[i] = 1;
        			fCol[j] = 1;
        		}
        	}
        }
        
        //set 0 to matrix according to flag array
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(fRow[i]==1 || fCol[j]==1){
        			matrix[i][j] = 0;
        		}
        	}
        }
    }
	
	
	public static void main(String args[]){
		
	}
}
