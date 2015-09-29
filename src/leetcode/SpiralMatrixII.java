package leetcode;

public class SpiralMatrixII {
	public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n==0){
        	return res;
        }
        
        int x=0;
        int y=0;
        int number=1;
        int result = n*n;
        while(n>0&&number<=result){
        	if(n==1){
        		res[x][y] = number;
        		return res;
        	}
        	//assign value from top-left to top-right
        	for(int i=0;i<n-1;i++){
        		res[x][y++] = number++;
        	}
        	
        	//assign value from top-right to bottom-right
        	for(int i=0;i<n-1;i++){
        		res[x++][y] = number++;
        	}
        	
        	//assign value from bottom-right to bottom-left
        	for(int i=0;i<n-1;i++){
        		res[x][y--] = number++;
        	}
        	
        	//assign value from bottom-left to top-right-1
        	for(int i=0;i<n-1;i++){
        		res[x--][y] = number++;
        	}
        	
        	x++;
        	y++;
        	n=n-2;
        	
        	
        }
        
        
        return res;
    }
	
	public static void main(String args[]){
		int n =4;
		 int[][] res = new int[n][n];
		 res = generateMatrix(n);
		 
		 for(int i=0;i<n;i++){
			 for(int j=0;j<n;j++){
				 System.out.println(res[i][j]);
			 }
		 }
	}
}
