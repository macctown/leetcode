package lcAgain;

import java.util.HashMap;
import java.util.HashSet;



//NOTE:  TWO directions relationship
//same solution for "Word Pattern"
public class IsomorphicStrings {
	//use one to check duplicate value and key
		public static boolean isIsomorphic2(String s, String t) {
	        if(s.length() != t.length()){
	            return false;
	        }
	        
	        HashMap<Character, Character> relationship1 = new HashMap<Character, Character>();
	        for(int i=0; i<s.length(); i++){
	            if(relationship1.containsKey(s.charAt(i))){
	                if(relationship1.get(s.charAt(i))!=t.charAt(i)){
	                    return false;
	                }
	            }
	            else if(relationship1.containsValue(t.charAt(i))){
	            	if(!relationship1.containsKey(s.charAt(i))){
	                    return false;
	                }
	            }
	            else{
	                relationship1.put(s.charAt(i), t.charAt(i));
	            }
	        }
	        
	        return true;
	    }
		
		//clean code of methods 2
		public static boolean isIsomorphic3(String s, String t) {
	        if(s.length() != t.length()){
	            return false;
	        }
	        
	        HashMap<Character, Character> re = new HashMap<Character, Character>();
	        
	        for(int i=0;i<s.length();i++){
	        	if(!re.containsKey(s.charAt(i))&&!re.containsValue(t.charAt(i))){
	        		re.put(s.charAt(i), t.charAt(i));
	        	}
	        	else if( !re.containsKey(s.charAt(i)) || re.get(s.charAt(i))!=t.charAt(i)){
	        		return false;
	        	}
	        		
	        }
	        
	        return true;
	    }
	
	
	
	
	//use two hash map to store the two directions relationship
	public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        
        HashMap<Character, Character> relationship1 = new HashMap<Character, Character>();
        HashMap<Character, Character> relationship2 = new HashMap<Character, Character>();
        for(int i=0; i<s.length(); i++){
            if(relationship1.containsKey(s.charAt(i))){
                if(relationship1.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
            else{
                relationship1.put(s.charAt(i), t.charAt(i));
            }
            
            if(relationship2.containsKey(t.charAt(i))){
                if(relationship2.get(t.charAt(i))!=s.charAt(i)){
                    return false;
                }
            }
            else{
                relationship2.put(t.charAt(i), s.charAt(i));
            }
        }
        
        return true;
    }
	
	
	
	
	public static void main(String args[]){
		System.out.println(isIsomorphic3("ab","aa"));
	}
}
