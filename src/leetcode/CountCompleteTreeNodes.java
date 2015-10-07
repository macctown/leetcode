package leetcode;

import java.util.LinkedList;
import java.util.List;

import leetcode.ValidateBST.TreeNode;

public class CountCompleteTreeNodes {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	public static int countNodes(TreeNode root) {
        int res = 0;
		if(root==null){
        	return res;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
        	TreeNode tmp = queue.poll();
        	res++;
        	
        	if(tmp.left!=null){
        		queue.add(tmp.left);
        	}
        	
        	if(tmp.right!=null){
        		queue.add(tmp.right);
        	}
        	
        }
        
        return res;
        
    }
	
	public static int countNodes2(TreeNode root) {
        int res = 0;
		if(root==null){
        	return res;
        }
		
		int left = countNodes2(root.left);
		int right = countNodes2(root.right);
		
		return left+right+1;
	}
	
	public static int countNodes3(TreeNode root) {
        int res = 0;
		if(root==null){
        	return res;
        }
		
		int leftMax = getLeft(root);
		int rightMax = getRight(root);
		//use attribute of complete binary tree
		if(leftMax == rightMax){
			return (int)Math.pow(2, leftMax)-1;
		}
		else{
			return countNodes2(root.left)+countNodes2(root.right)+1;
		}
		
	}
	
	
	private static int getRight(TreeNode root) {
		int res = 0;
		while(root!=null){
			root = root.right;
			res++;
		}	
		return res;
	}

	private static int getLeft(TreeNode root) {
		int res = 0;
		while(root!=null){
			root = root.left;
			res++;
		}	
		return res;
	}

	public static void main(String args[]){
		TreeNode test = new TreeNode(1);
    	TreeNode test21 = new TreeNode(2);
    	TreeNode test22 = new TreeNode(3);
    	TreeNode test31 = new TreeNode(4);
    	TreeNode test32 = new TreeNode(5);
    	TreeNode test33 = new TreeNode(6);
    	TreeNode test34 = new TreeNode(7);
    	test.left = test21;
    	test.right = test22;
    	test21.left = test31;
    	test21.right = test32;
    	test22.left = test33;
    	test22.right = test34;
    	int res = countNodes3(test);
    		 System.out.println(res);
	}
}
