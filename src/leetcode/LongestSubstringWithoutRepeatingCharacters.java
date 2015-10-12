package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
        	return 0;
        }
        
        int maxLength = 0;
        int fast = 0;
        int slow = 0;
        HashSet<Character> set = new HashSet<Character>();
        
        //loop from beginning to end of string
        while(fast < s.length()){
        	if(set.contains(s.charAt(fast))){
        		//encounter same letter
        		
        		//update maxLength
        		if(fast-slow > maxLength){
        			maxLength = fast-slow;
        		}
        		
        		//move slow pointer
        		while(s.charAt(slow)!=s.charAt(fast)){
        			//delete the letter occurs before(exclude the one fast point to)
        			//bcz the fast before can't be used when we count new length
        			//and those letters could be use later, so we delete them from set
        			set.remove(s.charAt(slow));
        			slow++;
        		}
        		slow++;
        	}else{
        		//no same letter in container
        		set.add(s.charAt(fast));
        	}
        	
        	fast++;
        }   
        maxLength = Math.max(maxLength, fast-slow);
        return maxLength;
    }
	
	
	public static void main(String args[]){
		System.out.println(lengthOfLongestSubstring("dababcdc"));
	}
}
