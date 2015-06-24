package leetcode;

public class strStr {
	//factor:
	//1.normal two string
	//2.two white string
	//3.haystack < needle
	//4.can't find until last letter in haystack
	public static int strStr(String haystack, String needle){
		if(haystack.length()<needle.length()){
			return -1;
		}
		if(haystack.equals(needle)){
		    return 0;
		}
		int position = 0;
		int sign = 0;
		for(int i=0;i<haystack.length();i++){
			sign = 0;
			position = 0;
			int k=i;
			System.out.print(" i: "+i);
			for(int j=0;j<needle.length();j++){
				System.out.print(" haystack: "+haystack.charAt(k));
				System.out.println(" needle: "+needle.charAt(j));
				if(haystack.charAt(k)!=needle.charAt(j)){
					break;
				}
				else{
					if(sign==0){
						position = i;
						System.out.println(" position: "+position);
						sign=1;
					}
					else{
						sign++;
						System.out.println(" sign: "+sign);
					}
					k++;
					System.out.println(" k: "+k);
					if(k>=haystack.length()&&sign!=needle.length()){
					    return -1;
					}
				}
			}
			if(sign == needle.length()){
				return position;
			}
		}
		if(sign == 0){
			return -1;
		}
		return position;
	}
	
	public static void main(String[] args){
		System.out.println(strStr("",""));
	}
}
