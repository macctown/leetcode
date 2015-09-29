package leetcode;

import leetcode.BuildBTByInorderPostorder.TreeNode;

public class BuildBTByPreorderInorder {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
        	return null;
        }
        
        TreeNode root = build_tree(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
        return root;
    }

	private TreeNode build_tree(int[] inorder, int istart, int iend, int[] preorder,
			int pstart, int pend) {
		// TODO Auto-generated method stub
		if(pstart>pend||istart>iend){
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[pstart]);
		int position = root_position(inorder, istart, iend, preorder[pstart]);
		
		root.left = build_tree(inorder, istart, position-1, preorder, pstart+1, pstart+position-istart);
		root.right =build_tree(inorder, position+1, iend, preorder, pstart+position-istart+1, pend);
		return root;
	}

	private int root_position(int[] inorder, int istart, int iend, int key) {
		// TODO Auto-generated method stub
		for(int i=istart;i<=iend;i++){
			if(inorder[i]==key){
				return i;
			}
		}
		return -1;
	}
	
	
}
