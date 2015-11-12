package lcAgain;

import leetcode.PartitionList.ListNode;

public class RemoveLinkedListElements {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
	public static ListNode removeElements(ListNode head, int val) {
		 if(head == null){
	            return head;
	        }
	        
	        ListNode dummy = new ListNode(Integer.MAX_VALUE);
	        dummy.next = head;
	        ListNode cur = dummy;
	        ListNode scan = cur.next;
	        
	        while(scan != null){
	            if(scan.val != val){
	                scan = scan.next;
	                cur = cur.next;
	            }
	            else if(scan.val == val){
	                while(scan!=null && scan.val == val ){
	                    scan = scan.next;
	                }
	                cur.next = scan;
	            }
	        }
	        
	        
	        return dummy.next;
    }
	
	public static void main(String args[]){
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(6);
    	ListNode l3 = new ListNode(6);
    	ListNode l4 = new ListNode(6);
    	ListNode l5 = new ListNode(5);
    	ListNode l6 = new ListNode(6);
    	

    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	l5.next = l6;
    	
    	ListNode res = removeElements(l1,6);
    	
    	while(res!=null){
    		System.out.println(res.val);
    		res = res.next;
    	}
    }
}
