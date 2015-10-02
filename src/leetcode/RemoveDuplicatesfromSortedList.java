package leetcode;

import leetcode.InsertionSortList.ListNode;

public class RemoveDuplicatesfromSortedList {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
	
	public static ListNode deleteDuplicates(ListNode head) {
        if(head==null){
        	return head;
        }
        //store head for return
        ListNode node1 = head;
        ListNode node2 = head.next;
        
        
         while(node2 != null){
        	 if(node1.val == node2.val){
        		 //if equals, just move node2 to next. to check if it's same again
        		 node2 = node2.next;
        		 //if node2 is null after move ,that means it's end now,
        		 if(node2 == null){
        			 //make node to null, bcz this means (1,1,1,1,1,1)
        			 node1.next = null;
        		 }
        	 }
        	 else{
        		 //link node1 to the first elements that differ from node1
        		 node1.next = node2;
        		 node1 = node1.next;
        		 node2 = node2.next; 
        	 }
        	 
        	 
         }
        
        return head;
        
    }
	
	public static void main(String args[]){
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(1);
    	ListNode l3 = new ListNode(2);
    	ListNode l4 = new ListNode(3);
    	ListNode l5 = new ListNode(3);
    	

    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	l4.next = l5;
    	
    	ListNode res = deleteDuplicates(l1);
    	
    	while(res!=null){
    		System.out.print("res:"+res.val);
    		res = res.next;
    	}
    }
}
