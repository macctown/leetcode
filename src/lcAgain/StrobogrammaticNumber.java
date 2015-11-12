package lcAgain;

import java.util.HashMap;

public class StrobogrammaticNumber {
	
	
	public static boolean isStrobogrammatic2(String num) {
        HashMap<Character, Character> rp = new HashMap<Character, Character>();
        rp.put('0','0');
        rp.put('1','1');
        rp.put('8','8');
        rp.put('6','9');
        rp.put('9','6');
        
        int res = num.length();
        int i=0;
        int j=num.length()-1;
        for(i=0, j=num.length()-1; i<j;i++,j--){
            if(rp.containsKey(num.charAt(i))){
                if(rp.get(num.charAt(i)) != num.charAt(j)){
                    return false;
                }
            }
            else{
                return false;
            }
            res = res-2;
        }
        
        if(res==1){
            if(rp.containsKey(num.charAt(i))){
                if(num.charAt(i) =='6' || num.charAt(i) =='9'){
                    return false;
                 }
            }
            else{
                return false;
            }
        }
        
        return true;
    }
	
	public static void main(String args[]){
		System.out.println(isStrobogrammatic2("69"));
		StringBuilder sb = new StringBuilder("");
		
	}
}
