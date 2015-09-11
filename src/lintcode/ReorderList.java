package lintcode;

import lintcode.SortList.ListNode;

public class ReorderList {
	/**
     * @param head: The head of linked list.
     * @return: void
     */
	
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	}
	
	//1. get reverse behind mid
	//2. merge head and reverse
    public static void reorderList(ListNode head) {  
    	if(head == null || head.next == null){
    		return;
    	}
    	ListNode mid = sfFindMiddle(head);System.out.println(mid.val);
    	ListNode rList = reverseList(mid.next);
    	mid.next = null;	
    	//note: the position of mid doesn't change after reverseList, it remains in the middle
    	//then mid.next = null make the head become first half of the list
    	
    	mergeTwoLists(head,rList);	
    }
      
    public static ListNode sfFindMiddle(ListNode head){
    	ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public static ListNode reverseList(ListNode head){
    	
    	if(head == null){
    		return head;
    	}
    	
    	ListNode p1,p2,p3;
    	
    	p1 = head;
    	p2 = p1.next;
    	while(p2!=null){
    		p3 = p2.next;
    		p2.next = p1;
    		p1 = p2;
    		p2 = p3;
    	}
    	
    	head.next = null;
    	head = p1;
    	return head;
    }
    
    public static void mergeTwoLists(ListNode l1, ListNode l2) {
      	
      	ListNode newList = new ListNode(Integer.MAX_VALUE);
      	
      	int count = 0;	//use count to merge two list just by position
    		while(l1!=null&&l2!=null){
    			if(count%2 ==0){
    				newList.next = l1;
    				l1 = l1.next;	//make list continue without influence dummy(dummy only record the beginning position)
    			}
    			else{
    				newList.next = l2;
    				l2 = l2.next;
    			}
    			newList = newList.next;
    			count++;
    		}
    		
    		//if some one has extra node, append it behind the newList
    		if(l1!=null){
    			newList.next = l1;
    		}
    		if(l2!=null){
    			newList.next = l2;
    		}
    		
      }
    
    
    public static void main(String args[]){
    	ListNode l0 = new ListNode(0);
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(4);
    	
    	l0.next = l1;
    	l1.next = l2;
    	l2.next = l3;
    	l3.next = l4;
    	reorderList(l1);
    }
}
