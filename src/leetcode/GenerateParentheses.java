package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n==0){
        	return res;
        }
        
        String tmp ="";
        dfs(res, tmp, n, n);
        
        return res;
    }

	private static void dfs(List<String> res, String tmp, int left, int right) {
		// TODO Auto-generated method stub
		if(left>right){
			return;
		}
		if(left == 0&&right==0){
			res.add(tmp.toString());
			return;
		}
		
		if(left>0){
			dfs(res, tmp+"(", left-1, right);
		}
		
		if(right>0){
			dfs(res, tmp+")", left, right-1);
		}
	}
	
	
	public static void main(String args[]){
		List<String> res = generateParenthesis(3);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
	}
	
	
}
