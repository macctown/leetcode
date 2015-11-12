package lcAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<char[], List<String>> map = new HashMap<char[], List<String>>();
        for(int i=0; i<strs.length; i++){
            char[] code = strs[i].toCharArray();
            Arrays.sort(code);
            
            if(map.containsKey(code)){
                map.get(code).add(strs[i]);
            }
            else{
                List<String> tmp = new ArrayList<String>();
                tmp.add(strs[i]);
                map.put(code, tmp);
            }
        }
        
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Entry en = (Entry)it.next();
            List<String> tmp = (List<String>)en.getValue();
            Collections.sort(tmp);
            res.add(tmp);
        }
        
        return res;
    }
	
	public static void main(String args[]){
		
	}
}
