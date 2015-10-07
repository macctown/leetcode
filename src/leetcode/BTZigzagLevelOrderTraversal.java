package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import leetcode.SumRoottoLeafNumbers.TreeNode;

public class BTZigzagLevelOrderTraversal {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null){
			return res;
		}
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> level = new ArrayList<Integer>();
		queue.add(root);
		int cur = 1;
		int next = 0;
		int depth = 1;
		while(!queue.isEmpty()){
			TreeNode tmp = queue.poll();
			cur--;
			level.add(tmp.val);
			
			if(tmp.left!=null){
				queue.add(tmp.left);
				next++;
			}
			
			if(tmp.right!=null){
				queue.add(tmp.right);
				next++;
			}
			
			
			if(cur==0){
				cur=next;
				next=0;
				if(depth%2==0){
					Collections.reverse(level);
				}
				res.add(level);
				level = new ArrayList<Integer>();
				depth++;
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
    	List<List<Integer>>  res = zigzagLevelOrder(test);
    	for(int i=0;i<res.size();i++){
   		 	for(int j=0;j<res.get(i).size();j++){
   	    		System.out.print(" "+res.get(i).get(j));
   		 	}
   		 	System.out.println();
    	}

	}
}
