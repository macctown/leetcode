package leetcode;

import java.util.List;

import leetcode.BTInorderTraversal.TreeNode;

public class FlattenBT {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	static TreeNode lastVisited = null;
	public static void flatten(TreeNode root) {
		if(root == null){
			return;
		}
		
		TreeNode tmp = root.right;
		
		if(lastVisited!=null){
			lastVisited.left = null;
			lastVisited.right = root;
		}
		
		lastVisited = root;
		flatten(root.left);
		flatten(tmp);
    }
	
	public static void preorder(TreeNode root){
		if(root == null){
			return;
		}
		
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
		
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
    	preorder(test);
	}
}
