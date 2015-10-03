package leetcode;

import leetcode.InsertionSortList.ListNode;

public class ReverseListII {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        //record the position before m
        ListNode pre = dummy;
        
        ListNode cur = head;
        //move cur to m
        //move pre to the one before m
        for(int i=0;i<m-1;i++){
        	pre = cur;
        	cur = cur.next;
        }
        
        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(0);
        if(cur!=null){
        	p1 = cur.next;
        }
        if(p1!=null){
        	p2 = p1.next;
        }
        //reverse and move forward
        for(int i=m;i<n;i++){
        	p1.next = cur;
        	cur = p1;
        	p1 = p2;
        	if(p2!=null) p2=p2.next;
        }
        //point to end
        pre.next.next = p1;
        
        //connect to cur
        pre.next = cur;
        
        return dummy.next;
    }
	
	public static void main(String args[]){
		ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(4);
    	ListNode l5 = new ListNode(5);
    	

    	l1.next = l2;
    	//l2.next = l3;
    	//l3.next = l4;
    	l4.next = l5;
    	
    	ListNode res = reverseBetween(l1,1,2);
    	while(res!=null){
    		System.out.println(res.val);
    		res = res.next;
    	}
    	
	}
}
