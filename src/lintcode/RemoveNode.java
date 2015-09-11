package lintcode;

import lintcode.ReorderList.ListNode;

public class RemoveNode {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	}
	
	public static ListNode removeNode(ListNode head, int k){
		//get the length
		int length = getLength(head);
		
		//k=1
		if(k==1){
			head = head.next;
			return head;
		}
		
		//0<k<=length
		if(k<=length){
			ListNode p0 = head;
			int count=1;
			while(p0!=null){
				if(count==k-1){
					p0.next = p0.next.next;
					return head;
				}
				p0 = p0.next;
				count++;
			}
		}
		
		return head;
	} 
	
	public static int getLength(ListNode head){
		int len = 0;
		while(head!=null){
			len++;
			head = head.next;
		}
		
		return len;
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
    	
    	ListNode res = removeNode(l1,6);
    	
    	while(res!=null){
    		System.out.println(res.val);
    		res = res.next;
    	}
	}
}
