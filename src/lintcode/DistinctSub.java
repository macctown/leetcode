package lintcode;

public class DistinctSub {
	 /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public static int numDistinct(String S, String T) {
        // write your code here
    	if(S==null||T==null){
    		return 0;
    	}
    	
    	int[][] num = new int[S.length()+1][T.length()+1];
    	
    	//num[i][0] means choose a empty(length = 0) string from first i letters in S
    	//the res is 1
    	for(int i=0;i<S.length();i++){
    		num[i][0] = 1;
    	}
    	
    	//i is index of S, j is index of T
    	for(int i=1;i<=S.length();i++){
    		for(int j=1;j<=T.length();j++){
    			if(S.charAt(i-1)==T.charAt(j-1)){
    				num[i][j] = num[i-1][j-1]+num[i-1][j];
    			}
    			else{
    				//if the letter are differ then the num[i][j] can only get from num[i-1][j]
    				//index in S move forward, but j doesn't need to move
    				num[i][j] = num[i-1][j];
    			}
    		}
    	}
    	
    	return num[S.length()][T.length()];
    }
    
    public static void main(String args[]){
    	String s = "rabbbit";
    	String b = "rabbit";
    	
    	System.out.println(numDistinct(s,b));
    }
}
