package leetcode;

public class CountandSay {
	public static String countAndSay(int n) {
		String  res= "1";
        for(int i=1;i<n;i++){
        	res = buildString(res);
        }
        
        return res;      
    }
	
	public static String buildString(String str){
		System.out.print(" str: "+str);
		//Type: StringBuilder
		String stb = new String();
		//Func: charAt
		char temp = str.charAt(0);
		if(str == "1"){
			return "11";
		}
		int count = 1;
		for(int i=1;i<str.length();i++){
			System.out.print(" charAt("+i+"): "+str.charAt(i));
			if(str.charAt(i)==temp){
				count++;
			}
			else{
				stb = stb + Integer.toString(count) + str.charAt(i-1);
				count=1;
			}
			temp = str.charAt(i);
			System.out.print(" stb-inside: "+stb);
		}
		stb = stb + Integer.toString(count) + str.charAt(str.length()-1);
		System.out.println(" stb: "+stb);
		return stb;
	}
	
	public static void main(String[] args){
		System.out.println(" result: "+countAndSay(6));
	}
}
