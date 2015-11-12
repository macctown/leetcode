package lcAgain;

import java.util.HashMap;

public class StrobogrammaticNumber {
	public static boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1','1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        for(int i=0, j=num.length()-1; i<=j; i++, j--){
            if( (!map.containsKey(j)) || (!map.containsKey(i)) || (num.charAt(i) != map.get(num.charAt(j))) ){

                return false;
            }
        }
       
        return true;
    }
	
	public static void main(String args[]){
		System.out.println(isStrobogrammatic("619"));
		StringBuilder sb = new StringBuilder("");
		
	}
}
