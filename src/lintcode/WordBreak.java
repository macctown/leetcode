package lintcode;

import java.util.Set;

public class WordBreak {
	/**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public static boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
    	if(s.length() == 0 || s == null){
    		return true;
    	}
    	
    	//calculate the max length of the word in dict
    	int maxLen = getMax(dict);
    	
    	//array to save res, true means the end of a word
    	boolean[] res = new boolean[s.length()+1];
    	res[0] = true;
    	
    	//loop from 1st letter to the last of String s
    	for(int i=1;i<=s.length();i++){
    		//initialize the res first
    		res[i] = false;
    		//loop from 1st letter of String s, the max is the max length of the word in dict
    		for(int j=1;j<=maxLen&&j<=i;j++){
    			if(!res[i-j]){
    				continue;
    			}
    			
    			String sub = s.substring(i-j, i);
    			if(dict.contains(sub)){
    				res[i] = true;
    				break;
    			}
    		}
    	}
    	
    	return res[s.length()];
    	
    }
    
    //get the max length of the words in dict
    public static int getMax(Set<String> set){
    	int max = 0;
    	for(String s : set){
    		max = Math.max(max, s.length());
    	}
    	
    	return max;
    }
    
}
