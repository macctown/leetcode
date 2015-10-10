package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

//can't use sum of string, bcz acd = abc
public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
		if(strs==null || strs.length==0){
        	return res;
        }
		
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		String keyStr = "";
		char[] tmp = null;
		for(int i=0;i<strs.length;i++){
			tmp = strs[i].toCharArray();
			Arrays.sort(tmp);
			keyStr = String.valueOf(tmp);
			if(map.containsKey(keyStr)){
				map.get(keyStr).add(strs[i]);
			}
			else{
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(keyStr, list);
			}
		}
		
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			List<String> tmpList = (List<String>)entry.getValue();
			Collections.sort(tmpList);
			res.add(tmpList);
		}
		return res;
    }


	public static void main(String args[]){
		String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = groupAnagrams(str);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(" "+res.get(i).get(j));
			}
			System.out.println();
		}
	}
}
