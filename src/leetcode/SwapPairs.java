package leetcode;

import leetcode.InsertionSortList.ListNode;

public class SwapPairs {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
	public static ListNode swapPairs(ListNode head) {
        if(head == null ||head.next ==null){
        	return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        //p1 point the one before pair
        ListNode p1 = dummy;
        //p2 point to the first one of pair
        ListNode p2 = head;
        
        //if odd, p2.next=null; if even, p2=null
        while(p2!=null&&p2.next!=null){
        	//tmp node point to the first one of next pair
        	ListNode next = p2.next.next;
        	//point 2nd to 1st in pair
        	p2.next.next = p2;
        	//point pre to the new 1st of pair
        	p1.next = p2.next;
        	//point 1st to the next pari
        	p2.next = next;
        	
        	//move forward
        	p1 = p2;
        	p2 = p2.next;     	
        }
        
        return dummy.next;
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
    	//l4.next = l5;
    	
    	ListNode res = swapPairs(l1);
    	while(res!=null){
    		System.out.println(res.val);
    		res = res.next;
    	}
    	
	}
	
	
}
