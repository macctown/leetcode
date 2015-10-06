package leetcode;

import leetcode.ValidateBST.TreeNode;

public class LowestCommonAncstor {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	//compare current node and the two node
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<root.val&&q.val<root.val){
        	return lowestCommonAncestor(root.left, p, q);
        }
        else if(p.val>root.val&&q.val>root.val){
        	return lowestCommonAncestor(root.right, p, q);
        }
        else{
        	return root;
        }
        
    }
}
