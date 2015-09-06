package lintcode;

public class LongestCommonSubsequence {
	/**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public static int longestCommonSubsequence(String A, String B) {
        //corner case
    	if(A ==null || B == null){
    		return 0;
    	}
    	
    	//set length+1 for array-trick
    	int[][] common = new int[A.length()+1][B.length()+1];
    	
    	//set initial value for first row and column
    	//common[i][0] means first i letters in A and 0 letters in B, which has no common sub
    	for(int i=0;i<A.length();i++){
    		common[i][0] = 0;
    	}
    	
    	//set initial value for first row and column
    	//common[0][i] means first i letters in B and 0 letters in A, which has no common sub
    	for(int i=0;i<B.length();i++){
    		common[0][i] = 0;
    	}
    	
    	//loop from second letter of A and <=length
    	for(int i=1;i<=A.length();i++){
    		//loop from second letter of B and <=length
    		for(int j=1;j<=B.length();j++){
    			//if A,B has same letter in same position, the common equals the last common+1
    			if(A.charAt(i-1)==B.charAt(j-1)){
    				common[i][j] = common[i-1][j-1]+1;
    			}
    			else{
    				//if A,B isn't same in same position, the common is the max of two elements below
    				common[i][j] = Math.max(common[i-1][j], common[i][j-1]);
    			}
    		}
    	}
    	
    	return common[A.length()][B.length()];
    }
    
    
    public static void main(String args[]){
    	String a = "ABCD";
    	String b = "EACB";
    	
    	System.out.println(longestCommonSubsequence(a,b));
    }
    
}
