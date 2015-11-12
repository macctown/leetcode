package lcAgain;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
        String newStr = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        System.out.println(newStr.length());
        for(int i=0, j=newStr.length()-1;i<=j;i++,j--){
            if(newStr.charAt(i)!=newStr.charAt(j)){
                return false;
            }
        }
        
        return true;
    }
	
	public static void main(String args[]){
		System.out.println(isPalindrome("."));
	}
}
