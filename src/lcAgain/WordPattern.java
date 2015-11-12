package lcAgain;

import java.util.HashMap;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		String[] strArr = str.split(" ");
        if(pattern.length()!=strArr.length){
            return false;
        }
        
        HashMap<Character, String> ptos = new HashMap<Character, String>();
        HashMap<String, Character> stop = new HashMap<String, Character>();
        for(int i=0; i<strArr.length;i++){
            if(ptos.containsKey(pattern.charAt(i))){
                if(!ptos.get(pattern.charAt(i)).equals(strArr[i])){
                    return false;
                }
            }
            else if(ptos.containsValue(strArr[i])){
                if(stop.get(strArr[i]) != pattern.charAt(i)){
                    return false;
                }
            }
            else{
                ptos.put(pattern.charAt(i), strArr[i]);
                stop.put(strArr[i], pattern.charAt(i));
            }
        }
        
        return true;
    }
}
