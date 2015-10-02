package leetcode;

import leetcode.InsertionSortList.ListNode;

public class SortList {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
	
	//merge sort: 1,find middle(slow, fast)   2.merge two list
	public static ListNode sortList(ListNode head) {
		if(head==null){
			return head;
		}
		
		ListNode mid = sfMiddle(head);

		ListNode right = sortList(mid.next);
		mid.next=null;
		ListNode left = sortList(head);
		
		return MergeTwoList(left, right);
		
    }
	
	
	private static ListNode MergeTwoList(ListNode left, ListNode right) {
		// TODO Auto-generated method stub
		ListNode Dummy = new ListNode(Integer.MIN_VALUE);
		ListNode newList = Dummy;
		
		while(left!=null&&right!=null){
			if(left.val<=right.val){
				newList.next = left;
				left = left.next;
			}
			else{
				newList.next = right;
				right = right.next;
			}
			newList = newList.next;
		}
		
		if(left!=null){
			newList.next = left;
		}
		if(right!=null){
			newList.next = right;
		}
		
		return Dummy.next;
	}




	private static ListNode sfMiddle(ListNode head) {
		// TODO Auto-generated method stub
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next!=null&&fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}




	public static void main(String args[]){
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(4);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(2);
    	ListNode l5 = new ListNode(5);
    	ListNode l6 = new ListNode(6);
    	

    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	l5.next = l6;
    	
    	ListNode res = sortList(l1);
    	
    	while(res!=null){
    		System.out.println(res.val);
    		res = res.next;
    	}
    }
}
