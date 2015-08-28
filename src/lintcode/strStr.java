package lintcode;

public class strStr {
	/**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
	
	//force-search
    public static int StrStr(String source, String target) {
        if(source==null||target==null)
        {
        	return -1;
        }
        
        if(source.length()<target.length())
        {
        	return -1;
        }
        
        if(target.length()==0)
        {
        	return 0;
        }
        
        int index = -1;
        for(int i=0;i<source.length();i++)
        {
        	System.out.println("i: "+i);
        	for(int j=0;j<target.length();j++)
        	{
        		System.out.println(" j: "+j);
        		System.out.println(" tar: "+target.charAt(j));
        		System.out.println(" sour: "+source.charAt(i+j));
        		if(target.charAt(j)!=source.charAt(i+j)){
        			break;
        		}
        		else{
        			index = i;
        			System.out.println(" index: "+index);
        			if(j==target.length()-1)
        			{
        				return index;
        			}
        		}	
        		
        	}
        }
        return -1;
    }
    
    public static void main(String args[]){
    	String source = "";
    	String target = "";
    	
    	int index = StrStr(source, target);
    	System.out.println(index);
    }
}
