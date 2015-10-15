package leetcode;

import java.util.Collections;

public class ReverseWordsinaString {
	public static String reverseWords(String s) {
        String res ="";
		if(s== null || s.length()==0){
        	return res;
        }
		
		String[] arr = s.split(" ");
		for(int i=arr.length-1;i>=0;i--){
			//avoid " " in s
			if(!arr[i].equals(""))
				res += arr[i]+" ";
		}
		
		if(res.length()==0) return "";
		return res.substring(0, res.length()-1);
    }
	
	public static void main(String args[]){
		System.out.println(reverseWords(" "));
	}
}
