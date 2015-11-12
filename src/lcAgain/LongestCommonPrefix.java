package lcAgain;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
	       if(strs.length==0 || strs==null){
	           return "";
	       } 
	       
	       for(int j=0;j<strs[0].length();j++){
	           char x = strs[0].charAt(j);
	           for(int k=1;k<strs.length;k++){
	               if(strs[k].length()==j || strs[k].charAt(j)!=x){
	                   return strs[0].substring(0,j);
	                   
	               }
	           }
	       }
	       
	       return strs[0];
	    }
}
