package lintcode;

import lintcode.ReverseLinkedListII.ListNode;

public class PartitionList {
	/**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	}
	
    public static ListNode partition(ListNode head, int x) {
        //corner case
    	if(head == null){
        	return head;
        }

        ListNode lDummy = new ListNode(Integer.MIN_VALUE);
        ListNode gDummy = new ListNode(Integer.MAX_VALUE);
        ListNode p0 = head, pl = lDummy, pg = gDummy;
        //loop from the first node of given list to the last
        while(p0!=null){
        	if(p0.val < x){
        		//if its value less than target, then make it into the lessList
        		pl.next = p0; //lDummy.next = p0(only the first time), so it records the beginning of pl
        		pl = p0;	//bcz here pl change his direction
        	}
        	else{
        		//if its value greater than or equals to target, then make it into the greaterList
        		pg.next = p0;	//gDummy.next = p0(only the first time), so it records the beginning of pg
        		pg = p0;	
        	}
        	p0 = p0.next;	//move the pointer towards
        }
        
        pg.next = null;		//make the greaterList ends with null
        pl.next = gDummy.next;	//connect lessList and greaterList
        
        return lDummy.next;
        
    }
    
    
    public static void main(String args[]){
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(4);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(2);
    	ListNode l5 = new ListNode(5);
    	ListNode l6 = new ListNode(2);
    	

    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	l5.next = l6;
    	
    	ListNode res = partition(l1,3);
    	
    	while(res!=null){
    		System.out.println(res.val);
    		res = res.next;
    	}
    }
}
