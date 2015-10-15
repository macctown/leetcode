package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public static List<String> restoreIpAddresses(String s) {
        List<String> res= new ArrayList<String>();
        //corner case
        if(s.length()<4 || s.length()>12){
        	return res;
        }
        String tmp = "";
        
        findIP(s, 0, tmp, res);
        
        return res;
    }

	private static void findIP(String s, int count, String tmp, List<String> res) {
		//when we complete the first three part, the left(s) can be append directly, but need to validate first
		if(count == 3 && isValid(s)){
			res.add(tmp +s);
			return;
		}
		
		for(int i=0;i<3 && i<s.length()-1; i++){
			String sub = s.substring(0, i+1);
			if(isValid(sub)){
				findIP(s.substring(i+1), count+1, tmp+sub+".", res);
			}
		}
		
		
		
	}

	private static boolean isValid(String tmp) {
		// TODO Auto-generated method stub
		if(tmp.charAt(0) == '0'){
			return tmp.equals("0");
		}
		
		int IP = Integer.parseInt(tmp);
		if(IP>255 || IP<=0){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static void main(String args[]){
		String test = "25525511135";
		List<String> res = restoreIpAddresses(test);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
	}
}
