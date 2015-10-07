package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import leetcode.ValidateBST.TreeNode;

public class BinaryTreePreorderTraversal {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
		if(root == null){
        	return res;
        }
		dfs(root, res);
		return res;
    }

	private static void dfs(TreeNode root, List<Integer> res) {
		// TODO Auto-generated method stub
		if(root==null){
			return;
		}
		
		res.add(root.val);
		dfs(root.left, res);
		dfs(root.right, res);
	}
	
	public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
		if(root == null){
        	return res;
        }
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while(!stack.isEmpty()||root!=null){
			if(root!=null){
				stack.push(root);
				res.add(root.val);
				root = root.left;
			}
			else{
				root = stack.pop();
				root = root.right;
			}
			
			
		}
		
		return res;
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
    	 List<Integer> res = preorderTraversal2(test);
    	 for(int i=0;i<res.size();i++){
    		 System.out.println(res.get(i));
    	 }
	}
}
