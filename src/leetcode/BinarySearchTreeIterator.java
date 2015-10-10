package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.ValidateBST.TreeNode;

public class BinarySearchTreeIterator {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	public List<TreeNode> stack =new ArrayList<TreeNode>();
	
	public BinarySearchTreeIterator(TreeNode root) {
		inorder(root, stack);
    }
	
	private static void inorder(TreeNode root, List<TreeNode> stack2) {
		// TODO Auto-generated method stub
		if(root == null){
			return;
		}
		
		inorder(root.left, stack2);
		stack2.add(root);
		inorder(root.right, stack2);
	}

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.isEmpty()==false){
        	return true;
        }
        else{
        	return false;
        }
    }

    /** @return the next smallest number */
    public int next() {
    	int res = stack.get(0).val;
    	stack.remove(0);
    	return res;
    }
    
    public static void main(String args[]){
		TreeNode test = new TreeNode(5);
    	TreeNode test21 = new TreeNode(2);
    	TreeNode test22 = new TreeNode(8);
    	TreeNode test31 = new TreeNode(1);
    	TreeNode test32 = new TreeNode(3);
    	TreeNode test41 = new TreeNode(7);
    	TreeNode test42 = new TreeNode(9);
    	test.left = test21;
    	test.right = test22;
    	test21.left = test31;
    	test21.right = test32;
    	test22.left = test41;
    	test22.right = test42;
    	BinarySearchTreeIterator i = new BinarySearchTreeIterator(test);
    	while(i.hasNext()){
    		System.out.println(i.next());
    	}
	}
    
}
