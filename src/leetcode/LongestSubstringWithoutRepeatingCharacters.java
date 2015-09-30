package leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
        if(s==null||s==""){
        	return 0;
        }
        int maxLength = 1;
        int res = -1;
        
        for(int i=0;i<s.length();i++){
        	maxLength=1;
        	for(int j=i;j<s.length();j++){
        		//System.out.println(maxLength);
        		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                int key = (int)s.charAt(j);
                
        		if(!map.containsKey(key)){

        			maxLength++;
        			map.put(key, maxLength);

        		}
        		else{	
        			break;
        		}
        	}
        	res = Math.max(maxLength, res);
        }
        
        return maxLength;
    }
	
	
	public static void main(String args[]){
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
}
