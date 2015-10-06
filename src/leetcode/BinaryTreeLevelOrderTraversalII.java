package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.BTInorderTraversal.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //corner case
        if(root == null){
        	return res;
        }
        
        int cur = 0;
        int next = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        cur = 1;
        ArrayList<Integer> leveltmp = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
        	TreeNode tmpNode = queue.poll();
        	cur--;
        	leveltmp.add(tmpNode.val);
        	
        	if(tmpNode.left!=null){
        		queue.add(tmpNode.left);
        		next++;
        	}
        	
        	if(tmpNode.right!=null){
        		queue.add(tmpNode.right);
        		next++;
        	}
        	
        	if(cur==0){
        		cur = next;
        		next =0;
        		res.add(0, leveltmp);			//NOTE: add every level res to the first position
        		leveltmp = new ArrayList<Integer>();
        	}
        }
        
        return res;
    }
}
