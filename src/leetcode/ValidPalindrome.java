package leetcode;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		if(s==null){
			return false;
		}
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for(int i=0, j=s.length()-1;i<j;i++,j--){
        	if(s.charAt(i)!=s.charAt(j)){
        		return false;
        	}
        }
        
        return true;
    }
	
	public static void main(String args[]){
		System.out.println(isPalindrome("A9man, a plan, a canal: Panam9a"));
	}
}
