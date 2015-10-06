package leetcode;

import java.util.LinkedList;

import leetcode.BTInorderTraversal.TreeNode;

public class PathSum {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	
	public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
        	return false;
        }
        
        sum = sum - root.val;
        if(root.left == null && root.right == null){
        	return sum==0;
        }
        else{
            return hasPathSum(root.left, sum)||	hasPathSum(root.right, sum);
        }
        
    }
	
	
	public static boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null){
        	return false;
        }
        
        LinkedList<TreeNode> nodeQ = new LinkedList<TreeNode>();
        LinkedList<Integer> valueQ = new LinkedList<Integer>();
        
        nodeQ.add(root);
        valueQ.add(root.val);
        
        while(!nodeQ.isEmpty()){
        	TreeNode tmpNode = nodeQ.poll();
        	int tmpValue = valueQ.poll();
        	
        	if(tmpNode.left==null&&tmpNode.right==null&&tmpValue==sum){
        		return true;
        	}
        	
        	if(tmpNode.left!=null){
        		nodeQ.add(tmpNode.left);
        		valueQ.add(tmpValue+tmpNode.left.val);
        	}
        	
        	if(tmpNode.right!=null){
        		nodeQ.add(tmpNode.right);
        		valueQ.add(tmpValue+tmpNode.right.val);
        	}
        }
        
        return false;
        
    }

	
	
}
