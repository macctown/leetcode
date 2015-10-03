package leetcode;

import leetcode.InsertionSortList.ListNode;

public class RotateList {	
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
	//find the first position of rotate, then append the elements before after the first part 
	//1,2,3,4,5-2    find position of 4 first, then append 1,2,3 after 5
	public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next==null){
        	return head;
        }
        ListNode lenNode = new ListNode(0);
        lenNode = head;
        int length = 0;
        while(lenNode!=null)
        {
        	length++;
        	lenNode = lenNode.next;
        }      
        
      //corner case
        k = k%length;
        if(k==0){
        	return head;
        }
        
        ListNode front = new ListNode(0);
        front.next = head;
        
        ListNode after = new ListNode(0);
        after.next = head;
        
        
        //slow/fast pointer to get the position of newHead and newTail
        for(int i=0;i<k;i++){
        	after = after.next;
        }
        
        while(after.next!=null){
        	after = after.next;
        	front = front.next;
        }
        
        //connect the new parts to each other
        ListNode start = front.next;
        ListNode end = after;
        after.next = head;
        front.next = null;
        
        
        
        return start;
    }
	
	public static void main(String args[]){
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(4);
    	ListNode l5 = new ListNode(5);
    	

    	l1.next = l2;
    	
    	ListNode res = rotateRight(l1,2);
    	
    	while(res!=null){
    		System.out.println(res.val);
    		res = res.next;
    	}
    }
}
