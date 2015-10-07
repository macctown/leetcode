package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.LowestCommonAncestorOfBT.TreeNode;

public class BTRightSideView {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res= new ArrayList<Integer>();
		if(root == null){
        	return res;
        }
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		int cur = 1;
		int next = 0;
		List<Integer> level = new ArrayList<Integer>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			TreeNode tmp = queue.poll();
			cur--;
			if(cur==0){
				res.add(tmp.val);
			}
			
			if(tmp.left!=null){
				queue.add(tmp.left);
				next++;
			}
			
			if(tmp.right!=null){
				queue.add(tmp.right);
				next++;
			}
			
			if(cur==0){
				cur = next;
				next = 0;
			}
			
		}
		return res;
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
    	 List<Integer> res = rightSideView(test);
    	 for(int i=0;i<res.size();i++){
    		 System.out.println(res.get(i));
    	 }
	}
}
