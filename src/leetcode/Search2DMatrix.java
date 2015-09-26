package leetcode;

public class Search2DMatrix {
	//1.check elements one by one
	//TC: O(?)
	public static boolean searchMatrix(int[][] matrix, int target) {  
		if(matrix==null || matrix.length == 0){
			return false;
		}
		
		int row = matrix.length-1;
        int col = 0;
        //find which row it belongs to 
        while(col<matrix[0].length && row>=0){
        	if(matrix[row][col] == target){
        		return true;
        	}
        	else if(matrix[row][col] < target){
        		col++;
        	}
        	else{
        		row--;
        	}
        }
        return false;
             
    }
	
	
	//2. use binary search, start = 0, end = m*n-1. Think the multi-row matrix as a one
	// hisRow = num/col, hisCol = num%col;
	
	
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
	    
	    System.out.println(searchMatrix(matrix, 0));
						
	}
}

