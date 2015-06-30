package leetcode;

public class LengthofLastWord {
	public static int lengthOfLastWord(String s) {
        String[] res = s.split(" ");
        if(res.length==0) 
        	return 0;
        else
        	return res[res.length-1].length();
        
    }
	
	public static void main(String[] args){
		System.out.println(lengthOfLastWord(""));
	}
}
