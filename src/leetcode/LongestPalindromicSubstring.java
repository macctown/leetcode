package leetcode;

public class LongestPalindromicSubstring {
	public static String longestPalindrome(String s) {
        String res = "";
		if(s==null||s.length()==0||s.length()==1){
        	return s;
        }
		
		for(int i=0;i<s.length()*2-1;i++){
			String tmp = helper(s, i, i);
			if(tmp.length()>res.length()){
				res = tmp;
			}
			
			tmp = helper(s, i, i+1);
			if(tmp.length()>res.length()){
				res = tmp;
			}
		}
		
		return res;
    }

	private static String helper(String s, int begin, int end) {
		// TODO Auto-generated method stub
		while(begin>=0&&end<=s.length()-1&&s.charAt(begin)==s.charAt(end)){
			begin--;
			end++;
		}
		return s.substring(begin+1, end);
	}
	
	
	public static String longestPalindrome2(String s) {
	
	}

	
	public static void main(String args[]){
		System.out.println(longestPalindrome(""));
	}
}
