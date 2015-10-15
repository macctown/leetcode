package leetcode;

public class DecodeWays {
	public static int numDecodings(String s) {
        if(s.length() == 0){
        	return 0;
        }
        
        int[] res = new int[s.length()+1];
        res[0] = 1;
        
        if(isValid(s.substring(0, 1))){
        	res[1] = 1;
        }
        else{
        	res[1] = 0;
        }
        //result from i is from i-1 and i-2, like 123, result[2] = result[1]+result[0]
        for(int i=2;i<=s.length();i++){
        	if(isValid(s.substring(i-1, i))){
        		res[i] += res[i-1];
        	}
        	if(isValid(s.substring(i-2, i))){
        		res[i] += res[i-2];
        	}
        }
        
        return res[s.length()];
    }

	private static boolean isValid(String str) {
		// TODO Auto-generated method stub
		if(str.charAt(0)=='0'){
			return false;
		}
		int tmp = Integer.valueOf(str);
		if(tmp >=1 && tmp<=26){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void main(String args[]){
		System.out.println(numDecodings("12"));
	}
}
