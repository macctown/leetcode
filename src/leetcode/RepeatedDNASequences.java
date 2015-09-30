package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
	public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
		if(s.length()==0||s==null){
        	return res;
        }
		
		HashSet<String> tmp = new HashSet<String>();
		for(int i=0;i<s.length()-9;i++){
			String sub = s.substring(i, i+10);
			if(tmp.contains(sub)){
				res.add(sub);
			}
			else{
				tmp.add(sub);
			}
		}
		
		return res;
    }
	
	public static List<String> findRepeatedDnaSequences2(String s) {
        List<String> result = new ArrayList<String>();
		if(s.length()==0||s==null){
        	return result;
        }
		
		int len = s.length();
		if (len < 10) {
			return result;
		}
	 
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
	 
		HashSet<Integer> temp = new HashSet<Integer>();
		HashSet<Integer> added = new HashSet<Integer>();
	 
		int hash = 0;
		for (int i = 0; i < len; i++) {
			if (i < 9) {
				//each ACGT fit 2 bits, so left shift 2
				hash = (hash << 2) + map.get(s.charAt(i)); 
			} else {
				hash = (hash << 2) + map.get(s.charAt(i));
				//make length of hash to be 20
				hash = hash &  (1 << 20) - 1; 
				if (temp.contains(hash) && !added.contains(hash)) {
					result.add(s.substring(i - 9, i + 1));
					added.add(hash); //track added, avoid duplicate result in result collection
				} else {
					temp.add(hash);	//check if its occur more than once
				}
			}
	 
		}
	 
		return result;
		
	}
	
	public static void main(String args[]){
		String test ="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> res = findRepeatedDnaSequences2(test);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
		
	}
}
