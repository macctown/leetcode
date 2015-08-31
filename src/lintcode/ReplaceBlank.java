package lintcode;

import java.util.Arrays;

public class ReplaceBlank {
	/**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public static int replaceBlank(char[] string, int length) {
        //consider corner condition
    	if(string == null || length<=0){
        	return 0;
        }
    	
    	int count = 0;
        int newlength = 0;
        char[] copyStr = string;
    	for(int i=0;i<length;i++){
        	if(string[i]==' '){
        		count++;
        	}
        }
    	newlength = length + 2*count;
    	
    	for(int j=length-1,k=newlength-1;j>=0;j--,k--){
    		System.out.print("j: "+j);
    		System.out.println(" k: "+k);
    		if(copyStr[j]==' '){
    			string[k]='0';
    			string[k-1]='2';
    			string[k-2]='%';
    			k=k-2;
    		}
    		else{
    			string[k]=copyStr[j];
    		}
    	}
    	return newlength;
    }
     
    public static void main(String[] args){
    	char[] strchar = new char[100];
    	String str = " helloworld";
    	for(int i=0;i<str.length();i++){
    		strchar[i]=str.charAt(i);
    	}
    	System.out.println(replaceBlank(strchar,str.length()));
    }
}
