package leetcode;

import java.util.ArrayList;

import leetcode.SortedArrayToBST.ListNode;
import leetcode.SortedArrayToBST.TreeNode;

public class SortedListToBST {
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
	  
	public static TreeNode sortedListToBST(ListNode head) {
        if(head==null){
        	return null;
        }
        ListNode lenNode = head;
        int length = 0;
        while(lenNode!=null){
        	length++;
        	lenNode = lenNode.next;
        }
        
        ArrayList<ListNode> arr = new ArrayList<ListNode>();
        arr.add(head);
        return sortedListToBST(arr, 0, length-1);
    }

	private static TreeNode sortedListToBST(ArrayList<ListNode> src, int start, int end) {
		if(start>end){
			return null;
		}
		
		int mid = start+(end-start)/2;
		TreeNode left = sortedListToBST(src, start, mid-1);
		TreeNode root = new TreeNode(src.get(0).val);
		
		root.left = left;
		src.set(0, src.get(0).next);
		root.right = sortedListToBST(src, mid+1, end);
		return root;
	}
}
