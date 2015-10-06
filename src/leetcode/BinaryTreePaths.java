package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.ValidateBST.TreeNode;

public class BinaryTreePaths {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	
	public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
		if(root == null){
        	return res;
        }
		
		String tmp = Integer.toString(root.val);
		getPath(root, res, tmp);
		return res;
    }


	private static void getPath(TreeNode root, List<String> res, String tmp) {
		if(root.left == null && root.right == null){
			res.add(tmp);
			return;
		}
		if(root.left!=null)
			getPath(root.left, res, tmp+"->"+Integer.toString(root.left.val));
		
		if(root.right!=null)
			getPath(root.right, res, tmp+"->"+Integer.toString(root.right.val));
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
    	 List<String> res = binaryTreePaths(test);
    	 for(int i=0;i<res.size();i++){
    		 System.out.println(res.get(i));
    	 }
	}
}
