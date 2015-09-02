package lintcode;

import java.util.ArrayList;
import java.util.Stack;

import lintcode.IsValidBST.TreeNode;

public class BinaryTreeInorder {
	public static class TreeNode {
		public int val;
		public TreeNode left, right;
		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
	
	/**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	TreeNode cur = root;
    	while(root!=null || !s.empty()){
    		while(cur!=null){
    			s.add(cur);
    			cur = cur.left;
    		}
    		cur = s.peek();
    		s.pop();
    		res.add(cur.val);
    		cur = cur.right;
    	}
    	
    	return res;
    }
    
    
    
    public static void main(String args[]){
    	
    }
}
