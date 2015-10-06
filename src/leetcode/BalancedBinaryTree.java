package leetcode;

import leetcode.ValidateBST.TreeNode;

public class BalancedBinaryTree {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	public static boolean isBalanced(TreeNode root) {
		return checkBalanced(root)==-1?false:true;
    }

	private static int checkBalanced(TreeNode root) {
		if(root == null){
			return 0;
		}
		int left = checkBalanced(root.left);
		int right = checkBalanced(root.right);
		
		if(left == -1||right == -1){
			return -1;
		}
		
		if(Math.abs(left-right)>2){
			return -1;
		}
		else{
			return Math.max(left, right)+1;
		}
		
	}
	
	
}
