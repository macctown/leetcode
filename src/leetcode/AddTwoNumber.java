package leetcode;

import leetcode.InsertionSortList.ListNode;

public class AddTwoNumber {
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
        	return l2;
        }
        if(l2==null){
        	return l1;
        }
        
        //get sum in this position of two linkedlist
        int sum = 0;
        
        ListNode dummy = new ListNode(-1);
        
        ListNode newList = dummy;
        
        while(l1!=null || l2!=null){
        	if(l1!=null){
        		sum += l1.val;
        		l1 =l1.next;
        	}
        	if(l2!=null){
        		sum += l2.val;
        		l2 =l2.next;
        	}
        	
        	newList.next = new ListNode(sum%10);
        	//进位
        	sum = sum/10;
        	newList = newList.next;
        }
        
        //整个数字多一位
        if(sum==1){
        	newList.next = new ListNode(1);
        }
        
        return dummy.next;
        
    }
}
