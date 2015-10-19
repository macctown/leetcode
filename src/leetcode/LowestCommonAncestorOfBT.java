package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.ValidateBST.TreeNode;

public class LowestCommonAncestorOfBT {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	//get inorder traversal from p to q
	//get postorder traversal 
	//loop from postorder from back to start, then find the first on in the inorder list
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
        	return null;
        }
        if(root.left == null || root.right == null){
        	return root;
        }
        
        List<TreeNode> inorder = new ArrayList<TreeNode>();
        List<TreeNode> postorder = new ArrayList<TreeNode>();
        getInorder(root,inorder, q);
        getPost(root, postorder);
        
        
        for(int i=postorder.size()-1;i>=0;i--){
        	if(inorder.contains(postorder.get(i))){
        		return postorder.get(i);
        	}
        }
        
        return null;
    }

	private static void getPost(TreeNode root, List<TreeNode> res) {
		if(root == null){
			return;
		}
		getPost(root.left, res);
		getPost(root.right, res);
		res.add(root);
	}
	static boolean flag = false;
	private static void getInorder(TreeNode root, List<TreeNode> res, TreeNode q) {
		// TODO Auto-generated method stub
		if(root == null){
			return;
		}
		if(root == q){
			flag = true;
		}
		getInorder(root.left, res, q);
		if(flag == false){
			res.add(root);
		}
		getInorder(root.right, res, q);
		
	}

	//get path from p-root, q-root, then find the same node
	public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null){
			return null;
		}
		
		List<TreeNode> pRoute = new ArrayList<TreeNode>();
        List<TreeNode> qRoute = new ArrayList<TreeNode>();
        getPath(root, p, pRoute);
        getPath(root, q, qRoute);
        
        for(int i=0;i<pRoute.size();i++){
      		 System.out.println(pRoute.get(i).val);
      	 }
        
        return null;
	}
	
	private static void getPath(TreeNode root, TreeNode p, List<TreeNode> Route) {
		// TODO Auto-generated method stub
		if(root.left == p&&root.right == p){
			return;
		}
		if(root.left!=p){
			Route.add(p);
			getPath(root.left, p, Route);
		}
		if(root.right!=p){
			Route.add(p);
			getPath(root.right, p, Route);
		}
		
	}
	
	public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null){
			return null;
		}
		
		if(root == p || root == q){
			return root;
		}
		
		TreeNode left = lowestCommonAncestor3(root.left, p , q);
		TreeNode right = lowestCommonAncestor3(root.right, p , q);
		
		if(left!=null&&right!=null){
			return root;
		}
		else if(left!=null){
			//no node found in the right, so all the node must in the left 
			return left;
		}
		else if(right!=null){
			return right;
		}
		else{
			return null;
		}
		
		
	}

	public static void main(String args[]){
		TreeNode test = new TreeNode(1);
    	TreeNode test21 = new TreeNode(2);
    	TreeNode test22 = new TreeNode(3);
    	TreeNode test31 = new TreeNode(4);
    	TreeNode test32 = new TreeNode(5);
    	TreeNode test41 = new TreeNode(6);
    	TreeNode test42 = new TreeNode(7);
    	test.left = test21;
    	test.right = test22;
    	test21.left = test31;
    	test21.right = test32;
    	test31.left = test41;
    	test32.right = test42;
    	
    	 TreeNode res = lowestCommonAncestor3(test, test31,test42);
    		 System.out.println(res.val);
	}

}
