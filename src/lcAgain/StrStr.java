package lcAgain;

public class StrStr {
	public static int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        
        int hay = 0;
        int ned = 0;
        boolean flag = false;
        while(hay<haystack.length()){
            if(haystack.charAt(hay)!=needle.charAt(ned)){
                if(flag) hay=hay-ned;
                flag = false;
                ned=0;
            }
            else{
               flag = true;
               ned++;
               if(ned==needle.length()){
                   return hay-needle.length()+1;
               }
            }
            hay++;
        }
        
        return -1;
    }
	
	
	public static int strStr2(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
       
        for(int i=0;i<haystack.length();i++){
        	int j = i;
        	int index = 0;
        	while(j<haystack.length() && index<=needle.length() && haystack.charAt(j)==needle.charAt(index)){
        		j++;
        		index++;
        		if(index == needle.length()){
        			return i;
        		}
        	}
        }
        
        return -1;
    }
	
	
	public static void main(String args[]){
		System.out.println(strStr2("mississippi","ii"));
	}
}
