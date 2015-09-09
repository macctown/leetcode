package lintcode;

import lintcode.ReverseLinkedListII.ListNode;

public class ReverseLinkedList {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	}
	
	public static ListNode reverse(ListNode head){
		//corner case
		if(head == null){
			return head;
		}
		
		//three pointer we need
		ListNode p1, p2, p3;
		//set the first two point
		p1=head;
		p2=p1.next;
		
		//the condition is p2 but not p2.next, bcz p2.next will ignore the last node
		while(p2!=null){
			p3 = p2.next;	//use p3 to store position that next loop starts
			p2.next = p1;	//point p2 back forward to p1
			p1 = p2;		//reset p1 position	to p2 which is the first one of the list
			p2 = p3;		//reset p2 position to p3 which we just store
		}
		
		head.next = null;	//make head.next null
		head = p1;			//reset head's first node which is p1
		return head;
	}
	
	public static void main(String args[]){
		ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(4);
    	ListNode l5 = new ListNode(5);
    	

    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	
    	ListNode res = reverse(l1);
    	
    	while(res!=null){
    		System.out.println(res.val);
    		res = res.next;
    	}
	}
}
