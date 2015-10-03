package leetcode;

import leetcode.InsertionSortList.ListNode;

public class PartitionList {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
	
	public static ListNode partition(ListNode head, int x) {
		if(head == null){
			return head;
		}
		
		
		ListNode ldummy = new ListNode(0); 
		ListNode rdummy = new ListNode(0);
		
		ListNode lfake = ldummy;
		ListNode rfake = rdummy;
		
		while(head!=null){
			if(head.val < x){
				lfake.next = head;
				lfake = head;
			}
			else if(head.val >= x){
				rfake.next = head;
				rfake = head;
			}
			head = head.next;
		}
		rfake.next = null;
		lfake.next = rdummy.next;
		return ldummy.next;
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
