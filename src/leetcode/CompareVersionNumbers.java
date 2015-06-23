package leetcode;

public class CompareVersionNumbers {
	public static int compareVersion(String version1, String version2) {	
		if(!version1.contains(".")){
			version1 += ".0";
		}
		if(!version2.contains(".")){
			version2 += ".0";
		}
				
		
		String[] str1 = version1.split("\\.");
		Long[] l1 = new Long[str1.length];
		for(int i=0;i<str1.length;i++){
			l1[i] = Long.parseLong(str1[i]);
		}
		
		
		String[] str2 = version2.split("\\.");
		Long[] l2 = new Long[str2.length];
		for(int i=0;i<str2.length;i++){
			l2[i] = Long.parseLong(str2[i]);
			System.out.println("l2[i] :"+l2[i]);
		}
		
		
		int length = str1.length < str2.length ? str1.length : str2.length;
		System.out.println("length: "+str2.length);
		for(int j=0;j<length;j++){
			System.out.print("l1: "+l1[j]);
			System.out.println(" l2: "+l2[j]);
			if(l1[j]>l2[j]){
				return 1;
			}
			else if(l1[j]<l2[j]){
				return -1;
			}
			else{
				if(j==(length-1)&&(str1.length==str2.length)){
					return 0;
				}
				else if(j==(length-1)&&(str1.length>str2.length)){
					if(l1[length]==0){
						return 0;
					}
					else{
						return 1;
					}
				}
				else if(j==(length-1)&&(str1.length<str2.length)){
					if(l2[length]==0){
						return 0;
					}
					else{
						return -1;
					}
				}
				continue;
			}
		}
		
		return 0;
		
    }
	
	
	public static int compareVersion1(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
    
	    for ( int i = 0; i < Math.max(v1.length, v2.length); i++ ) {
	        int num1 = i < v1.length ? Integer.parseInt( v1[i] ) : 0;
	        int num2 = i < v2.length ? Integer.parseInt( v2[i] ) : 0;
	        if ( num1 < num2 ) {
	            return -1;
	        } else if ( num1 > num2 ) {
	            return +1;
	        }
	    } 
	    
	    return 0;
	
    }
	
	public static void main(String[] args){
		System.out.println(compareVersion("1.1","1.01.0"));
	}
}
