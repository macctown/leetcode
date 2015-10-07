package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.LowestCommonAncestorOfBT.TreeNode;

public class PathSumII {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null){
        	return res;
		}
		 
		List<Integer> tmp = new ArrayList<Integer>();
		recordPath(root, res, sum, tmp);
		
		return res;
    }

	private static void recordPath(TreeNode root, List<List<Integer>> res, int sum,
			List<Integer> tmp) {
		// TODO Auto-generated method stub
		if(root == null){
			return;
		}

		tmp.add(root.val);
		sum = sum-root.val;
		
		if(root.left==null&&root.right==null){
			if(sum == 0){
				res.add(new ArrayList<Integer>(tmp));
			}
		}
		else{
			if(root.left!=null)
				recordPath(root.left, res, sum, tmp);
			if(root.right!=null)
				recordPath(root.right, res, sum, tmp);
		}
		tmp.remove(tmp.size()-1);
	}

	public static void main(String args[]){
		TreeNode test = new TreeNode(1);
    	TreeNode test21 = new TreeNode(2);
    	TreeNode test22 = new TreeNode(3);
    	TreeNode test31 = new TreeNode(4);
    	TreeNode test32 = new TreeNode(5);
    	test.left = test21;
    	test.right = test22;
    	test21.left = test31;
    	test21.right = test32;
    	List<List<Integer>> res = pathSum(test, 7);
    	 for(int i=0;i<res.size();i++){
    		 for(int j=0;j<res.get(i).size();j++){
    			 System.out.print(" "+res.get(i).get(j));
    		 }
    		 System.out.println();
    	 }
	}
	
}
