package leetcode;

public class BuildBTByInorderPostorder {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	
	//note: last element of postorder is root
	//note: elements at left of root in inorder is left son tree, same in right
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0||postorder.length==0){
        	return null;
        }
        
        TreeNode root = build_helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        
        return root;
    }
	
	private static TreeNode build_helper(int[] inorder, int istart, int iend,
			int[] postorder, int pstart, int pend) {
		if(istart>iend||pstart>pend){
			return null;
		}
		
		//find root
		TreeNode root = new TreeNode(postorder[pend]);
		int position = find_position(inorder, istart, iend, postorder[pend]);
		
		
		
		//build left son
		root.left = build_helper(inorder, istart, position-1, postorder, pstart, pstart+position-istart-1);
		//build right son
		root.right = build_helper(inorder, position+1, iend, postorder, pstart+position-istart, pend-1);
		
		
		return root;
	}

	private static int find_position(int[] inorder, int start, int end, int target) {
		// TODO Auto-generated method stub
		for(int i=start;i<=end;i++){
			if(inorder[i]==target){
				return i;
			}
		}
		return -1;
	}

	public static void main(String args[]){
		
	}
}
