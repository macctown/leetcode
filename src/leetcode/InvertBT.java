package leetcode;

import java.util.LinkedList;

import leetcode.BinaryTreePaths.TreeNode;

public class InvertBT {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	public static TreeNode invertTree(TreeNode root) {
        if(root == null){
        	return null;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
        	TreeNode tmpNode = queue.poll();
        	
        	
        	if(tmpNode.left!=null&&tmpNode.right==null){
        		queue.add(tmpNode.left);
        	}
        	if(tmpNode.left==null&&tmpNode.right!=null){
        		queue.add(tmpNode.right);
        		
        	}
        	if(tmpNode.left!=null&&tmpNode.right!=null){
        		queue.add(tmpNode.left);
        		queue.add(tmpNode.right);
        		
        	}

    		TreeNode swapNode = tmpNode.left;
    		tmpNode.left = tmpNode.right;
    		tmpNode.right = swapNode;
        	
        }
        
        return root;
    }
	
	public static TreeNode invertTree2(TreeNode root) {
		if(root == null){
			return null;
		}
		
		TreeNode tmp = root.left;
		root.left = invertTree2(root.right);
		root.right = invertTree2(tmp);
		
		return root;
	}
}
