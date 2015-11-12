package lcAgain;

import leetcode.PartitionList.ListNode;

public class RemoveLinkedListElements {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
	public static ListNode removeElements(ListNode head, int val) {
		 ListNode dummy = new ListNode(Integer.MIN_VALUE); 	
		ListNode scan = head;
	        ListNode pre = new ListNode(Integer.MIN_VALUE); 
	        pre = dummy;
	        dummy.next = head;
	        
	        while(scan!=null){
	            if(scan.val == val){
	                pre.next = pre.next.next;
	            }
	            else{
	                pre = pre.next;
	            }
	            
	            scan = scan.next;
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
    	

    	//l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	l5.next = l6;
    	
    	ListNode res = removeElements(l1,1);
    	
    	while(res!=null){
    		System.out.println(res.val);
    		res = res.next;
    	}
    }
}
