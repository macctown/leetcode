package lintcode;

import java.util.ArrayList;

public class MaxDepth {
	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
	
	public static class TreeNode {
		public int val;
		public TreeNode left, right;
		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
	
    public static int maxDepth(TreeNode root) {
        // write your code here
    	if(root == null){
    		return 0;
    	}
    	
    	return getDepth(root, 1);
    }
    
    public static int getDepth(TreeNode root, int depth){
    	int dL = depth;
    	int dR = depth;
    	if(root.left!=null){	
    		dL++;
    		dL = getDepth(root.left, depth+1);
    	}
    	
    	if(root.right!=null){
    		dR++;
    		dR = getDepth(root.right, depth+1);
    	}
    	return Math.max(dR, dL);
    }

    public static int maxDepth2(TreeNode root){
    	if(root == null){
            return 0;
        }
    	
    	ArrayList<TreeNode> start = new ArrayList<TreeNode>();
    	int depth = 0;
    	
    	start.add(root);
    	while(!start.isEmpty()){
    		ArrayList<TreeNode> next = new ArrayList<TreeNode>();
    		for(TreeNode node : start){
    			if(node.left != null){
    				next.add(node.left);
    			}
    			if(node.right != null){
    				next.add(node.right);
    			}
    		}
    		start = new ArrayList<TreeNode>(next);
    		depth++;
    	}
    	
    	return depth;
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
    	
    	
    	System.out.println(maxDepth2(test));
    }
}
