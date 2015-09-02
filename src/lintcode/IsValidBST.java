package lintcode;

import java.util.ArrayList;
import java.util.Stack;

import lintcode.PreorderTraversal.TreeNode;

public class IsValidBST {
	public static class TreeNode {
		public int val;
		public TreeNode left, right;
		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
	
	public static boolean isValidBST(TreeNode root) {
        boolean res = true;
		if(root == null){
        	return true;
        }
        else{
        	res = helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
       return res;
    }
	
	public static boolean helper(TreeNode node, int min, int max){
		if(!(node.left == null && node.right == null)){
			return false; 
		}
		else if(min >= node.val || max <= node.val){
			return false;
		}
		
		
		return helper(node.left, node.left.left.val, node.left.right.val)&&helper(node.right, node.right.left.val, node.right.right.val);
	}
	
	public static boolean isValidBST2(TreeNode root){
		boolean res=true;
		if(root==null){
			return res;
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = inorderTraversal(root);
		
		for(int i=0;i<arr.size()-1;i++){
			if(arr.get(i)>arr.get(i+1)){
				return false;
			}
		}
		return res;
	}
	
	public static ArrayList<Integer> inorderTraversal(TreeNode root) {
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
		TreeNode test = new TreeNode(1);
    	TreeNode test21 = new TreeNode(2);
    	TreeNode test22 = new TreeNode(3);
    	TreeNode test31 = new TreeNode(4);
    	TreeNode test32 = new TreeNode(5);
    	test.left = test21;
    	test.right = test22;
    	test21.left = test31;
    	test21.right = test32;
    	System.out.println(isValidBST(test));
    	
	}
}
