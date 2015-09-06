package lintcode;

public class LongestCommonSubstring {
	/**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public static int longestCommonSubstring(String A, String B) {
        // write your code here
    	if(A == null || B == null){
    		return 0;
    	}
    	
    	int max = 0;
    	
    	for(int i=0;i<A.length();i++){
    		for(int j=0;j<B.length();j++){
    			//check the same order and length words in two strings
    			int len = 0;	//means the length of common sub
    			while(i+len<A.length()&&j+len<B.length()&&A.charAt(i+len)==B.charAt(j+len)){
    				len++;	//if same in order, len++
    				max = Math.max(len, max);	//give max the bigger value
    			}
    		}
    	}
    	
    	return max;
    }
    
    public static void main(String args[]){
    	String A = "ABCD";
    	String B = "CBCE";
    	
    	System.out.println(longestCommonSubstring(A,B));
    }
}
