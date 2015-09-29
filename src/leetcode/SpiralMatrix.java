package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
		if(matrix.length==0||matrix==null){
        	return res;
        }
		int m = matrix.length;
		int n = matrix[0].length;
		
		
		
		
		
		int row=0;
		int col=0;
		while(m>0&&n>0){
			//single col or row/ has single col or row left
			//need
			if(m==1){
				for(int i=0;i<n;i++){
					res.add(matrix[row][col]);
					col++;
				}
				return res;
			}
			else if(n==1){
				for(int i=0;i<m;i++){
					res.add(matrix[row][col]);
					row++;
				}
				return res;
			}
			
			
			
			//left top to right top
			for(int i=0;i<n-1;i++){
				res.add(matrix[row][col]);
				col++;
			}
			
			
			//left top to bottom left
			for(int i=0;i<m-1;i++){
				res.add(matrix[row][col]);
				row++;
			}
			
			//bottom to right
			for(int i=0;i<n-1;i++){
				res.add(matrix[row][col]);
				col--;
			}
			
			//then bottom-left to up
			for(int i=0;i<m-1;i++){
				res.add(matrix[row][col]);
				row--; //extra row-- operation
				
			}
			
			//after a circle, then change boundary
			row++;	//get row back
			col++;
			m=m-2;	//boudary is 2 less, bcz the elements around the circle has been added 
			n=n-2;
			
		}
		
		return res;
    }
}
