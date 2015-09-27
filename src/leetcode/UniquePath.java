package leetcode;

public class UniquePath {
	public static int uniquePaths(int m, int n) {
        if(m==0&&n==0){
        	return 0;
        }
        
        int[][] step = new int[100][100];
        //initialize
        for(int i=0;i<n-1;i++){
        	step[0][i] = 1;
        }
        
        for(int i=0;i<m-1;i++){
        	step[i][0] = 1;
        }
        
        for(int i=1;i<m;i++){
        	for(int j=1;j<n;j++){
        		step[i][j] = step[i-1][j]+step[i][j-1];
        	}
        }
        
        return step[m-1][n-1];
        
    }
	
	public static void main(String args[]){
		
	}
}	
