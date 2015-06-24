package leetcode;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
        String str = s.replaceAll("[^A-Za-z0-9 ]", "");
        str = str.replace(" ", "");
        
        str = str.toLowerCase();
        
        StringBuffer res = new StringBuffer(str);
        if(res.reverse().toString().equals(str)) 
        	return true;
        else
        	return false;
    }
	
	public static void main(String[] args){
		System.out.println(isPalindrome("A man, a plan, a canal: Panma"));
	}
}
