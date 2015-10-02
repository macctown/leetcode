package leetcode;

import leetcode.CycleList.ListNode;

public class CycleListII {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	}
	
	public ListNode detectCycle(ListNode head) {
      if(head==null){
      	return null;
      }
      
      ListNode slow = head;
      ListNode fast = head;
      
      while(fast!=slow){
      	if(fast.next==null||fast.next.next==null){
      		return null;
      	}
      	fast = fast.next.next;
      	slow = slow.next;
      }
      
      while(head!=slow){
    	  slow = slow.next;
    	  head = head.next;
      }
      
      
      return slow;
  }
}
