package leetcode;

public class RotateImage {
	//change position by diagonal, then change by axis of symmetry
	//TC: O(n^2)
	public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
        	return;
        }
        int n = matrix.length;
        
        //对角线转换
        for(int i=0;i<n;i++){
        	for(int j=i+1;j<n;j++){
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = temp;
        	}
        }
        
        //水平对称轴转换
        for(int i=0;i<n;i++){
        	for(int j=0;j<n/2;j++){
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[i][n-j-1];
        		matrix[i][n-j-1] = temp;
        	}
        }
        
    }

	public static void main(String args[]){
		int[][] matrix = new int[3][4];
		matrix[0][0] = 1;
	    matrix[0][1] = 3;
	    matrix[0][2] = 5;
	    matrix[0][3] = 7;
	    
	    matrix[1][0] = 10;
	    matrix[1][1] = 11;
	    matrix[1][2] = 16;
	    matrix[1][3] = 20;
	    
	    matrix[2][0] = 23;
	    matrix[2][1] = 30;
	    matrix[2][2] = 34;
	    matrix[2][3] = 50;
	}
}
