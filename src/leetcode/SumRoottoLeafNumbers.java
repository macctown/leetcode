package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.BTInorderTraversal.TreeNode;

public class SumRoottoLeafNumbers {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	 
	//dfs get every number
	public static int sumNumbers(TreeNode root) {
        int res = 0;
		if(root==null){
        	return res;
        }
		String tmp = "";
		List<Integer> list = new ArrayList<Integer>();	
		dfs(root, tmp, list);
		
		for(int i=0;i<list.size();i++){
			res = res + list.get(i);
		}
		
		return res;
    }

	private static void dfs(TreeNode root, String tmp,
			List<Integer> list) {
		// TODO Auto-generated method stub
		if(root.left == null&&root.right==null){
			tmp +=Integer.toString(root.val);
			list.add(Integer.parseInt(tmp));
			return;
		}
		
		tmp +=Integer.toString(root.val);
		if(root.left!=null)
			dfs(root.left, tmp, list);
		
		if(root.right!=null)
			dfs(root.right, tmp, list);
	}
	
	public static void main(String args[]){
		TreeNode test = new TreeNode(4);
    	TreeNode test21 = new TreeNode(9);
    	TreeNode test22 = new TreeNode(0);
    	TreeNode test31 = new TreeNode(4);
    	TreeNode test32 = new TreeNode(1);
    	test.left = test21;
    	test.right = test22;
    	//test21.left = test31;
    	test21.right = test32;
    	 int res = sumNumbers(test);
    		 System.out.println(res);
	}
	
	
	
	
}
