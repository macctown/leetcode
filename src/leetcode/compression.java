package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class compression {
	static String compress(String str) {
        String res = "";
		if(str==null||str==""){
        	return res;
        }
		
		HashMap<Character, Integer> recordMap = new HashMap<Character, Integer>();
		for(int poi=0; poi<str.length() ; poi++){
			if(recordMap.containsKey(str.charAt(poi))){
				recordMap.put(str.charAt(poi), recordMap.get(str.charAt(poi))+1);
			}
			else if(!recordMap.containsKey(str.charAt(poi))){		
				recordMap.put(str.charAt(poi), 1);
				res += str.charAt(poi);
				if(recordMap.get(str.charAt(poi))>1)
					res += recordMap.get(str.charAt(poi));
			}
		}
		
		/*Iterator it = recordMap.entrySet().iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
    		if((Integer)entry.getValue()>1){
    			res += entry.getKey().toString();
    			res += Integer.toString((Integer)entry.getValue());
    		}
    		else{
    			res += entry.getKey().toString();
    		}
		}*/
		
		
		return res;

    }
	
	static String compress2(String str) {
		String res = "";
		if(str==null||str==""){
        	return res;
        }
		
		
		int letterCount = 1;
		for(int poi=1;poi<str.length();poi++){
			if(str.charAt(poi)!=str.charAt(poi-1)){
				res += str.charAt(poi);
				if(letterCount != 1)
					res += Integer.toString(letterCount);
				letterCount = 1;
			}else{
				letterCount++;
			}
		}
		
	
		
		return res;
		
	}
	
	public static void main(String args[]){
		System.out.println(compress2("aabbbbdssfy"));
	}
}
