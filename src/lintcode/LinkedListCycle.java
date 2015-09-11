package lintcode;

import lintcode.SortList.ListNode;

public class LinkedListCycle {
	 /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
	
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	}
	
	//if there's a cycle in the list
	//the fast pointer can catch up with the slow pointer
    public static boolean hasCycle(ListNode head) {  
        //corner case
    	if(head == null){
    		return false;
    	}
    	
    	ListNode slow = head, fast = head;
    	while(fast.next!=null&&fast.next.next!=null){
    		//move first, or they will be same at begining
    		fast = fast.next.next;
    		slow = slow.next;
    		
    		if(fast == slow){
    			return true;
    		}
    	}
    	
    	return false;
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
    	l5.next = l3;
    	
    	boolean res = hasCycle(l1);
    	System.out.println(res);
    }
}
