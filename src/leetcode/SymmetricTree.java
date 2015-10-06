package leetcode;

import java.util.LinkedList;

import leetcode.PathSum.TreeNode;

public class SymmetricTree {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	
	public static boolean isSymmetric(TreeNode root) {
        //corner case
		if(root == null){
			return true;
		}
		return isSymmetricTree(root.left, root.right);
    }


	private static boolean isSymmetricTree(TreeNode left, TreeNode right) {
		// TODO Auto-generated method stub
		if(left==null&&right==null){
			return true;
		}
		
		if(left==null||right==null){
			return false;
		}
		
		return (left.val==right.val)&&isSymmetricTree(left.left, right.right)&&isSymmetricTree(left.right, right.left);
	}
	
	//use two queue, check they are same or not
	public static boolean isSymmetric2(TreeNode root) {
        
		//corner case
		if(root == null){
			return false;
		}
		
		LinkedList<TreeNode> left = new LinkedList<TreeNode>(); 
		LinkedList<TreeNode> right = new LinkedList<TreeNode>(); 
		left.add(root.left);
		right.add(root.right);
		
		while((!left.isEmpty())&&(!right.isEmpty())){
			TreeNode tmpLeft = left.poll();
			TreeNode tmpRight = right.poll();
			
			//different value->false
			if(tmpLeft.val!=tmpRight.val){
				return false;
			}
			
			//one of them is null-> false
			if((tmpLeft.left == null && tmpRight.right != null) || (tmpLeft.left != null && tmpRight.right == null))
	            return false;
	        if((tmpLeft.right == null && tmpRight.left != null) || (tmpLeft.right != null && tmpRight.left == null))
	            return false;
			
	        //add child to queue
			if(tmpLeft.left!=null&&tmpRight.right!=null){
				left.add(tmpLeft.left);
				right.add(tmpRight.right);
			}
			
			if(tmpRight.left!=null&&tmpLeft.right!=null){
				right.add(tmpRight.left);
				left.add(tmpRight.right);
			}
			
		}
		
		return true;
    }
	
	
}
