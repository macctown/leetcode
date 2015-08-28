package lintcode;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetsWithDup {
	/**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        Collections.sort(S);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        dfs(res,tmp,S,0);
        return res;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> tmp, ArrayList<Integer> s, int level) {
		// TODO Auto-generated method stub
		if(level == s.size()){
			//get to the bottom
				//System.out.println("before-add-to-res: "+res);
			if(!res.contains(new ArrayList<Integer>(tmp)))
				res.add(new ArrayList<Integer>(tmp));
				//System.out.println("after-add-to-res: "+res);
			return;
		}
		
		//left tree-null
		dfs(res,tmp,s,level+1);
		
		//right tree-element
			//System.out.print("before-add: "+tmp);
		tmp.add(s.get(level));
			//System.out.print("	after-add: "+tmp);
		dfs(res,tmp,s,level+1);
			//System.out.print("	before: "+tmp);
			//System.out.print("	delete: "+tmp.get(tmp.size()-1));
		tmp.remove(tmp.size()-1);
			//System.out.println("	after: "+tmp);
	}
    
    public static void main(String args[]){
    	ArrayList<Integer> test = new ArrayList<Integer>();
    	test.add(1);
    	test.add(2);
    	test.add(2);
    	System.out.println(subsetsWithDup(test));
    }
}
