package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.ValidateBST.TreeNode;

public class KthSmallestElementInBST {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	//inorder
	public static int kthSmallest(TreeNode root, int k) {
        if(root == null){
        	return -1;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        
        return list.get(k-1);
    }

	private static void inorder(TreeNode root, List<Integer> list) {
		// TODO Auto-generated method stub
		if(root == null){
			return;
		}
		
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}
	
	public static void main(String args[]){
		TreeNode test = new TreeNode(4);
    	TreeNode test21 = new TreeNode(2);
    	TreeNode test22 = new TreeNode(5);
    	TreeNode test31 = new TreeNode(1);
    	TreeNode test32 = new TreeNode(3);
    	test.left = test21;
    	test.right = test22;
    	test21.left = test31;
    	test21.right = test32;
    	 int res = kthSmallest(test,3);
    		 System.out.println(res);
	}
}
