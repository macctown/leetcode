package leetcode;

import leetcode.PathSum.TreeNode;

public class MinDepthofBT {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	public static int minDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //NOTE: if there's only one child-node, return the half have node
        if(left == 0||right==0){
        	return Math.max(left, right)+1;
        }
        return Math.min(left, right)+1;
        
    }
}
