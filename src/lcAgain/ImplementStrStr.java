package lcAgain;

public class ImplementStrStr {
	public static int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()){
            return -1;
        }
        if(needle.length()==0){
            return 0;
        }
        
        int indexStr = 0;
        for(int i=0; i<haystack.length(); i++){
            if(haystack.charAt(i)==needle.charAt(indexStr)){
            	for(int j=i; j<haystack.length();j++){
            		if(haystack.charAt(j) != needle.charAt(indexStr)){
            			break;
            		}
            		else{
            			
            		}
            	}
                
            }
           
        }
        return -1;
    }
	
	public static void main(String args[]){
		System.out.println(strStr("mississippi","issip"));
	}
}
