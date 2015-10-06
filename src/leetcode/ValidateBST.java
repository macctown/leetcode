package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import leetcode.BuildBTByInorderPostorder.TreeNode;

public class ValidateBST {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	//1.recursion, max of left should be less than root, min of right shoule be larger than root
	//little bug for value larger than min or max of Integer
	public static boolean isValidBST(TreeNode root) {
		if(root == null){
			return true;
		}
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	public static boolean isBST(TreeNode root, int minValue, int maxValue) {
		if(root == null){
			return true;
		}
		if(minValue<root.val&&root.val<maxValue){
			return isBST(root.left, minValue, root.val)&&isBST(root.right, root.val, maxValue);
		}
		else{
			return false;
		}
	}

	//2.inorder traverse, then check if it's ascending
	public static boolean isValidBST2(TreeNode root) {
        return inorderTraverse(root);
    }
	static TreeNode pre = null;
	public static boolean inorderTraverse(TreeNode root) {
		if(root==null)
			return true;
	
		if(!inorderTraverse(root.left))
			return false;
		
		if(pre!=null){
			if(root.val<=pre.val)
				return false;
		}
		pre = root;
		if(!inorderTraverse(root.right))
			return false;
		return true;
	}
}
