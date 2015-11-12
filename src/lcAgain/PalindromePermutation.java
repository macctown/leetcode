package lcAgain;

import java.util.HashMap;

public class PalindromePermutation {
	  public boolean canPermutePalindrome(String s) {
		  HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        
	        for(int i=0; i<s.length();i++){
	            if(map.containsKey(s.charAt(i))){
	                 map.remove(s.charAt(i));
	            }
	            else{
	                map.put(s.charAt(i),1);
	            }
	        }
	        
	        return map.size()==1 || map.size()==0;
	    }
}
