package lintcode;

import lintcode.RemoveDuplicatesSortedListII.ListNode;

public class ReverseLinkedListII {
	/**
     * @param ListNode head is the head of the linked list 
     * @param m and n
     * @return: The head of the reversed ListNode
     */
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	}
	
    public static ListNode reverseBetween(ListNode head, int m , int n) {
        //corner case
    	if(head == null){
    		return head;
    	}
    	
    	ListNode p0,p1,p2,p3;	//the pointers used in reverse
    	ListNode dummy = new ListNode(Integer.MIN_VALUE);	//dummy node
    	ListNode preNode = dummy;	//the pointers used to record position before the reverse
    	dummy.next = head;
    	p0 = head;		//p0 used to move pointer to the first node of reverse
    	for(int i=0;i<m-1;i++){
    		preNode = p0;
    		p0 = p0.next;
    	}
    	//basic linkedlist reverse
    	p1 = p0;	//p1 is the first node of reverse
    	p2 = p1.next;
    	
    	int start = m;	//the condition here need a plus, pointer can't exceed n
    	while(p2!=null&&start<n){
    		p3 = p2.next;
    		p2.next = p1;
    		p1=p2;
    		p2=p3;
    		start++;
    	}
    	preNode.next = p1;	//connect the reverse part and the node before it
    	
    	//move pointer to the last node of reverse part
    	for(int i=0;i<n-m;i++){
    		p1 = p1.next;
    	}
    	p1.next = p2;	//connect the reverse part and the part after that
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
    	l4.next = l5;
    	
    	ListNode res = reverseBetween(l1,2,4);
    	
    	while(res!=null){
    		System.out.println(res.val);
    		res = res.next;
    	}
    	
    }
}
