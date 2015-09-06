package lintcode;

public class LongestCommonSubsequence {
	/**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public static int longestCommonSubsequence(String A, String B) {
        // write your code here
    	if(A ==null || B == null){
    		return 0;
    	}
    	
    	int[][] common = new int[A.length()+1][B.length()+1];
    	
    	for(int i=0;i<A.length();i++){
    		common[i][0] = 0;
    	}
    	
    	for(int i=0;i<B.length();i++){
    		common[0][i] = 0;
    	}
    	
    	for(int i=1;i<=A.length();i++){
    		for(int j=1;j<=B.length();j++){
    			if(A.charAt(i-1)==B.charAt(j-1)){
    				common[i][j] = common[i-1][j-1]+1;
    			}
    			else{
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
