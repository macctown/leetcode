package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.ValidateBST.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 } 
	
	
	//use queue, push child and pop in order
	public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null){
        	return res;
        }
       
        LinkedList<TreeNode> queue =  new LinkedList<TreeNode>();
        queue.add(root);
        int cur = 1;
        int next = 0;	//use to record number of elements of next level
        List<Integer> tmp = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
        	//get the on in the peek, add the its childs, then pop it out
        	TreeNode tmpNode = queue.poll();
        	cur--;
        	tmp.add(tmpNode.val); 
        	
        	if(tmpNode.left!=null) {
        		queue.add(tmpNode.left);
        		next++;
        	}
        	if(tmpNode.right!=null){
        		queue.add(tmpNode.right);
        		next++;
        	}
        	
        	//get into next level
        	if(cur==0){
        		cur = next;
        		next = 0;
        		res.add(tmp);
        		tmp = new ArrayList<Integer>();	//only initialize when get into new level
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
    	test21.left = test;
    	test21.right = test22;
    	test.left = test31;
    	test.right = test32;
    	List<List<Integer>> res = levelOrder(test21);
    	for(int i=0;i<res.size();i++){
    		for(int j=0;j<res.get(i).size();j++){
    			System.out.println(res.get(i).get(j));
    		}
    	}
    	
	}
	
}
