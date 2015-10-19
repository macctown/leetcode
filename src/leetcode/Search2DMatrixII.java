package leetcode;

public class Search2DMatrixII {
	public static boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int rCount = row -1;
        int cCount = 0;
        while(rCount >=0 && cCount<col){
        	if(matrix[rCount][cCount] == target){
        		return true;
        	}
        	
        	if(matrix[rCount][cCount] < target){
        		cCount++;
        	}
        	else{
        		rCount--;
        	}
        }
        
        return res;
    }
	
	public static void main(String args[]){
		int[][] matrix = new int[3][4];
		matrix[0][0] = 1;
	    matrix[0][1] = 4;
	    matrix[0][2] = 7;
	    matrix[0][3] = 11;
	    
	    matrix[1][0] = 2;
	    matrix[1][1] = 5;
	    matrix[1][2] = 8;
	    matrix[1][3] = 12;
	    
	    matrix[2][0] = 3;
	    matrix[2][1] = 6;
	    matrix[2][2] = 9;
	    matrix[2][3] = 16;
	    
	    System.out.println(searchMatrix(matrix, 0));
	}
}
