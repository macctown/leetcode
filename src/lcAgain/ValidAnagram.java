package lcAgain;

import java.util.Arrays;

public class ValidAnagram {
	public static boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        Arrays.sort(c1);
        char[] c2 = t.toCharArray();
        Arrays.sort(c2);
        return String.valueOf(c1).equals(String.valueOf(c2));
    }
	
	
	
	public static void main(String args[]){
		String s1 = "";
		String s2 = "";
		System.out.println(isAnagram(s1, s2));
	}
}
