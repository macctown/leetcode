package leetcode;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length()==0 || wordDict.isEmpty()){
        	return false;
        }
        
        int maxWord = getMax(wordDict);
        
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        
        for(int i=1;i<s.length();i++){
        	res[i] = false;
        	for(int j=1; j<=maxWord&&j<=i;j++){
        		String word = s.substring(i-j, j);
        	}
        	
        }
        
    }

	private int getMax(Set<String> wordDict) {
		// TODO Auto-generated method stub
		int maxLen = 0;
		for(String word:wordDict){
			maxLen = Math.max(maxLen, word.length());
		}
		return maxLen;
	}
}
