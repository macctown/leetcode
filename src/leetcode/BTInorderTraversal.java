package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.BuildBTByInorderPostorder.TreeNode;

public class BTInorderTraversal {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	public  static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null){
        	return res;
        }
        traverse_dfs(root, res);
        
        
        return res;
    }
	
	private static void traverse_dfs(TreeNode root,List<Integer> res) {
		if(root==null){
			return;
		}
		traverse_dfs(root.left, res);
		res.add(root.val);
		traverse_dfs(root.right, res);
		
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
    	 List<Integer> res = inorderTraversal(test);
    	 for(int i=0;i<res.size();i++){
    		 System.out.println(res.get(i));
    	 }
	}
}
