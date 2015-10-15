package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationOfaPhoneNumber {
	public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length()==0){
        	return res;
        }
        StringBuilder tmp = new StringBuilder();
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, " ");
        dfs(res, map, tmp, 0, digits);
        
        return res;
    }

	private static void dfs(List<String> res, HashMap<Integer, String> map, StringBuilder tmp,
			int num, String digits) {
		// TODO Auto-generated method stub
		if(num == digits.length()){
			res.add(tmp.toString());
			return;
		}
		Integer key = Integer.valueOf(String.valueOf(digits.charAt(num)));
		String letters = map.get(key);
		for(int i=0;i<letters.length();i++){
			tmp.append(letters.charAt(i));
			//NOTE: the num+1 and num++ and ++num is different
			dfs(res, map, tmp, num+1, digits);
			tmp.deleteCharAt(tmp.length()-1);
		}
	}
	
	public static void main(String args[]){
		String test = "23";
		List<String> res = letterCombinations(test);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
	}
}
