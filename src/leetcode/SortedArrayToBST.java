package leetcode;

public class SortedArrayToBST {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	  
	  
	public static TreeNode sortedArrayToBST(int[] nums) {
		  if(nums==null||nums.length==0){
			  return null;
		  }
		  
		  return sortedArrayToBST(nums, 0, nums.length-1);
	}


	public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		if(start>end){
			return null;
		}
		
		int mid = start+(end-start)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, start, mid-1);
		root.right = sortedArrayToBST(nums, mid+1, end);
		
		
		return root;
	}
}
