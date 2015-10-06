package leetcode;

import java.util.LinkedList;
import java.util.List;

import leetcode.PathSum.TreeNode;

public class MaxDepthofBT {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	//recursion
	public static int maxDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax)+1;
    }
	
	
	//non-recurson, explore the tree by level
	public static int maxDepth2(TreeNode root) {
        if(root == null){
        	return 0;
        }
     
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int cur = 1;
        int next = 0;
        int level = 0;
        
        while(!queue.isEmpty()){
        	TreeNode tmpNode = queue.poll();
        	cur--;
        	
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
        		next = 0;
        		level ++;
        	}
        }
        
        return level;
        
   }

	
	public static void main(String args[]){
		TreeNode test = new TreeNode(1);
    	TreeNode test21 = new TreeNode(2);
    	TreeNode test22 = new TreeNode(3);
    	TreeNode test31 = new TreeNode(4);
    	TreeNode test32 = new TreeNode(5);
    	TreeNode test41 = new TreeNode(6);
    	test.left = test21;
    	test.right = test22;
    	test21.left = test31;
    	test21.right = test32;
    	test31.right = test41;
    	 int res = maxDepth2(test);
    	 
    		 System.out.println(res);
    	 
	}
}
